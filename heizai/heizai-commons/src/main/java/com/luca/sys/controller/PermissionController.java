package com.luca.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luca.pojo.vo.ResponseVO;
import com.luca.sys.entity.Permission;
import com.luca.sys.service.IPermissionService;
import com.luca.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
@Api(tags = "资源表")
@RestController
@RequestMapping("/sys/permission")
public class PermissionController {

    @Autowired
    IPermissionService iPermissionService;

    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页号", dataTypeClass = Long.class),
        @ApiImplicitParam(name = "size", value = "每页显示条数", dataTypeClass = Long.class)
    })
    @PostMapping("/query")
    public ResponseVO<Page<Permission>> query(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "10") Long size) {
        Page<Permission> page = new Page<>(current, size);
        Page<Permission> permissionPage = iPermissionService.listPage(page);
        return ResultUtil.success(permissionPage);
    }

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping("")
    public ResponseVO<Permission> create(@RequestBody Permission permission) {
        iPermissionService.create(permission);
        return ResultUtil.success(permission);
    }

    @ApiOperation(value = "获取", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseVO<Permission> get(@PathVariable Long id) {
        return ResultUtil.success(iPermissionService.get(id));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public ResponseVO<String> update(@PathVariable Long id, @RequestBody Permission permission) {
        permission.setId(id);
        return ResultUtil.success(iPermissionService.update(permission));
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseVO<String> remove(@PathVariable Long id) {
        return ResultUtil.success(iPermissionService.remove(id));
    }

}
