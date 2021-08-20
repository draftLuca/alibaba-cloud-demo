package com.luca.controller;


import com.luca.pojo.entity.Dept;
import com.luca.service.IDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门 前端控制器
 * </p>
 *
 * @author luca
 * @since 2021-03-27
 */
@RestController
@RequestMapping("/dept")
@Api(tags = "部门相关")
public class DeptController {
    @Autowired
    IDeptService iDeptService;

    @PostMapping("")
    @ApiOperation(value = "部门")
    public Dept triggerDeptEvent(@RequestBody Dept dept) {
        Dept dept2 = iDeptService.getById(dept.getId());
        return dept;
    }

}
