package com.luca.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luca.pojo.vo.ResponseVO;
import com.luca.sys.entity.RolePermission;
import com.luca.sys.service.IRolePermissionService;
import com.luca.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色资源表 前端控制器
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
@Api(tags = "角色资源表")
@RestController
@RequestMapping("/sys/role-permission")
public class RolePermissionController {

    @Autowired
    IRolePermissionService iRolePermissionService;

    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页号", dataTypeClass = Long.class),
        @ApiImplicitParam(name = "size", value = "每页显示条数", dataTypeClass = Long.class)
    })
    @PostMapping("/query")
    public ResponseVO<Page<RolePermission>> query(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "10") Long size) {
        Page<RolePermission> page = new Page<>(current, size);
        Page<RolePermission> rolePermissionPage = iRolePermissionService.listPage(page);
        return ResultUtil.success(rolePermissionPage);
    }

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping("")
    public ResponseVO<RolePermission> create(@RequestBody RolePermission rolePermission) {
        iRolePermissionService.create(rolePermission);
        return ResultUtil.success(rolePermission);
    }

    @ApiOperation(value = "获取", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseVO<RolePermission> get(@PathVariable Long id) {
        return ResultUtil.success(iRolePermissionService.get(id));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public ResponseVO<String> update(@PathVariable Long id, @RequestBody RolePermission rolePermission) {
        rolePermission.setId(id);
        return ResultUtil.success(iRolePermissionService.update(rolePermission));
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseVO<String> remove(@PathVariable Long id) {
        return ResultUtil.success(iRolePermissionService.remove(id));
    }

}
