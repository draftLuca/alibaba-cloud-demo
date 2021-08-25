package com.luca.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luca.pojo.vo.ResponseVO;
import com.luca.sys.entity.RoleResources;
import com.luca.sys.service.IRoleResourcesService;
import com.luca.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "")
@RestController
@RequestMapping("/sys/role-resources")
public class RoleResourcesController {

    @Autowired
    IRoleResourcesService iRoleResourcesService;

    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页号", dataTypeClass = Long.class),
        @ApiImplicitParam(name = "size", value = "每页显示条数", dataTypeClass = Long.class)
    })
    @PostMapping("/query")
    public ResponseVO<Page<RoleResources>> query(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "10") Long size) {
        Page<RoleResources> page = new Page<>(current, size);
        Page<RoleResources> roleResourcesPage = iRoleResourcesService.listPage(page);
        return ResultUtil.success(roleResourcesPage);
    }

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping("")
    public ResponseVO<RoleResources> create(@RequestBody RoleResources roleResources) {
        iRoleResourcesService.create(roleResources);
        return ResultUtil.success(roleResources);
    }

    @ApiOperation(value = "获取", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseVO<RoleResources> get(@PathVariable Long id) {
        return ResultUtil.success(iRoleResourcesService.get(id));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public ResponseVO<String> update(@PathVariable Long id, @RequestBody RoleResources roleResources) {
        roleResources.setId(id);
        return ResultUtil.success(iRoleResourcesService.update(roleResources));
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseVO<String> remove(@PathVariable Long id) {
        return ResultUtil.success(iRoleResourcesService.remove(id));
    }

}
