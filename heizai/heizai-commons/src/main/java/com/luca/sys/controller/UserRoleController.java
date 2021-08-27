package com.luca.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luca.pojo.vo.ResponseVO;
import com.luca.sys.entity.UserRole;
import com.luca.sys.service.IUserRoleService;
import com.luca.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
@Api(tags = "用户角色表")
@RestController
@RequestMapping("/sys/user-role")
public class UserRoleController {

    @Autowired
    IUserRoleService iUserRoleService;

    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页号", dataTypeClass = Long.class),
        @ApiImplicitParam(name = "size", value = "每页显示条数", dataTypeClass = Long.class)
    })
    @PostMapping("/query")
    public ResponseVO<Page<UserRole>> query(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "10") Long size) {
        Page<UserRole> page = new Page<>(current, size);
        Page<UserRole> userRolePage = iUserRoleService.listPage(page);
        return ResultUtil.success(userRolePage);
    }

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping("")
    public ResponseVO<UserRole> create(@RequestBody UserRole userRole) {
        iUserRoleService.create(userRole);
        return ResultUtil.success(userRole);
    }

    @ApiOperation(value = "获取", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseVO<UserRole> get(@PathVariable Long id) {
        return ResultUtil.success(iUserRoleService.get(id));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public ResponseVO<String> update(@PathVariable Long id, @RequestBody UserRole userRole) {
        userRole.setId(id);
        return ResultUtil.success(iUserRoleService.update(userRole));
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseVO<String> remove(@PathVariable Long id) {
        return ResultUtil.success(iUserRoleService.remove(id));
    }

}
