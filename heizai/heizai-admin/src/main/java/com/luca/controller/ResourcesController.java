package com.luca.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luca.pojo.vo.ResponseVO;
import com.luca.sys.entity.Resources;
import com.luca.sys.service.IResourcesService;
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
@RequestMapping("/sys/resources")
public class ResourcesController {

    @Autowired
    IResourcesService iResourcesService;

    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页号", dataTypeClass = Long.class),
        @ApiImplicitParam(name = "size", value = "每页显示条数", dataTypeClass = Long.class)
    })
    @PostMapping("/query")
    public ResponseVO<Page<Resources>> query(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "10") Long size) {
        Page<Resources> page = new Page<>(current, size);
        Page<Resources> resourcesPage = iResourcesService.listPage(page);
        return ResultUtil.success(resourcesPage);
    }

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping("")
    public ResponseVO<Resources> create(@RequestBody Resources resources) {
        iResourcesService.create(resources);
        return ResultUtil.success(resources);
    }

    @ApiOperation(value = "获取", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseVO<Resources> get(@PathVariable Long id) {
        return ResultUtil.success(iResourcesService.get(id));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public ResponseVO<String> update(@PathVariable Long id, @RequestBody Resources resources) {
        resources.setId(id);
        return ResultUtil.success(iResourcesService.update(resources));
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseVO<String> remove(@PathVariable Long id) {
        return ResultUtil.success(iResourcesService.remove(id));
    }

}
