package com.luca.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luca.consts.Constant;
import com.luca.exception.CustomUnauthorizedException;
import com.luca.pojo.vo.ResponseVO;
import com.luca.sys.entity.User;
import com.luca.sys.service.IUserService;
import com.luca.util.AesCipherUtil;
import com.luca.util.JedisUtil;
import com.luca.util.JwtUtil;
import com.luca.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
@Api(tags = "用户表")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    /**
     * RefreshToken过期时间
     */
    @Value("${refreshTokenExpireTime}")
    private String refreshTokenExpireTime;


    @Autowired
    IUserService iUserService;

    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页号", dataTypeClass = Long.class),
        @ApiImplicitParam(name = "size", value = "每页显示条数", dataTypeClass = Long.class)
    })
    @PostMapping("/query")
    @RequiresPermissions(logical = Logical.AND, value = {"user:delete"})
    public ResponseVO<Page<User>> query(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "10") Long size) {
        Page<User> page = new Page<>(current, size);
        Page<User> userPage = iUserService.listPage(page);
        return ResultUtil.success(userPage);
    }

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping("")
    @RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
    public ResponseVO<User> create(@RequestBody User user) {
        iUserService.create(user);
        return ResultUtil.success(user);
    }

    @ApiOperation(value = "获取", httpMethod = "GET")
    @GetMapping("/{id}")
    @RequiresAuthentication
    public ResponseVO<User> get(@PathVariable Long id) {
        return ResultUtil.success(iUserService.get(id));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    @RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
    public ResponseVO<String> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return ResultUtil.success(iUserService.update(user));
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    @RequiresPermissions(logical = Logical.AND, value = {"user:delete"})
    public ResponseVO<String> remove(@PathVariable Long id) {
        return ResultUtil.success(iUserService.remove(id));
    }

    /**
     * 登录授权
     * @param userDto
     * @return com.wang.model.common.ResponseBean
     * @author dolyw.com
     * @date 2018/8/30 16:21
     */
    @PostMapping("/login")
    public ResponseVO login(@RequestBody User userDto, HttpServletResponse httpServletResponse) {
        // 查询数据库中的帐号信息
        User userDtoTemp = iUserService.getOne(Wrappers.lambdaQuery(new User()).eq(User::getAccount, userDto.getAccount()));
        if (userDtoTemp == null) {
            throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
        }
        // 密码进行AES解密
        String key = AesCipherUtil.deCrypto(userDtoTemp.getPassword());
        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
//        if (key.equals(userDto.getAccount() + userDto.getPassword())) {
        if (key.equals(userDto.getPassword())) {
            // 清除可能存在的Shiro权限信息缓存
            if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + userDto.getAccount())) {
                JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + userDto.getAccount());
            }
            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
            JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + userDto.getAccount(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
            String token = JwtUtil.sign(userDto.getAccount(), currentTimeMillis);
            httpServletResponse.setHeader("Authorization", token);
            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
            return new ResponseVO(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
        } else {
            throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
        }
    }
}
