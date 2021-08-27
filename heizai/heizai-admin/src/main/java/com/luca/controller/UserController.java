package com.luca.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luca.pojo.vo.ResponseVO;
import com.luca.sys.entity.User;
import com.luca.sys.service.IUserService;
import com.luca.util.PasswordUtil;
import com.luca.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luca
 * @since 2021-08-25
 */
@Slf4j
@Api(tags = "")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页号", dataTypeClass = Long.class),
        @ApiImplicitParam(name = "size", value = "每页显示条数", dataTypeClass = Long.class)
    })
    @PostMapping("/query")
    public ResponseVO<Page<User>> query(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "10") Long size) {
        Page<User> page = new Page<>(current, size);
        Page<User> userPage = iUserService.listPage(page);
        return ResultUtil.success(userPage);
    }

    @RequiresPermissions("user:add")
    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping("")
    public ResponseVO<User> create(@RequestBody User user) throws Exception {
        user.setPassword(PasswordUtil.encrypt(user.getPassword(), user.getUsername()));
        iUserService.create(user);
        return ResultUtil.success(user);
    }

    @ApiOperation(value = "获取", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseVO<User> get(@PathVariable Long id) {
        return ResultUtil.success(iUserService.get(id));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public ResponseVO<String> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return ResultUtil.success(iUserService.update(user));
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseVO<String> remove(@PathVariable Long id) {
        return ResultUtil.success(iUserService.remove(id));
    }

    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/signin")
    @ResponseBody
    public ResponseVO submitLogin(@RequestBody User user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到xxRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
            return ResultUtil.success("登录成功！");
        } catch (Exception e) {
            log.error("登录失败，用户名[{}]", user.getUsername(), e);
            token.clear();
            return ResultUtil.error(e.getMessage());
        }
    }
}
