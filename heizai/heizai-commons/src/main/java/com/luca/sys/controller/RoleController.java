package com.luca.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luca.pojo.vo.ResponseVO;
import com.luca.sys.entity.Role;
import com.luca.sys.service.IRoleService;
import com.luca.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
@Api(tags = "角色表")
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Autowired
    IRoleService iRoleService;

    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页号", dataTypeClass = Long.class),
        @ApiImplicitParam(name = "size", value = "每页显示条数", dataTypeClass = Long.class)
    })
    @PostMapping("/query")
    public ResponseVO<Page<Role>> query(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "10") Long size) {
        Page<Role> page = new Page<>(current, size);
        Page<Role> rolePage = iRoleService.listPage(page);
        return ResultUtil.success(rolePage);
    }

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping("")
    public ResponseVO<Role> create(@RequestBody Role role) {
        iRoleService.create(role);
        return ResultUtil.success(role);
    }

    @ApiOperation(value = "获取", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseVO<Role> get(@PathVariable Long id) {
        return ResultUtil.success(iRoleService.get(id));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public ResponseVO<String> update(@PathVariable Long id, @RequestBody Role role) {
        role.setId(id);
        return ResultUtil.success(iRoleService.update(role));
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseVO<String> remove(@PathVariable Long id) {
        return ResultUtil.success(iRoleService.remove(id));
    }

}
