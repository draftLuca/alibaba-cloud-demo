package com.luca.controller;


import com.luca.entity.Dept;
import com.luca.service.IDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
@Api(tags = "spring事件")
public class EventTestController {

    @Autowired
    IDeptService iDeptService;

    @GetMapping("")
    @ApiOperation(value = "触发部门事件")
    public Dept triggerDeptEvent() {
        Dept dept = iDeptService.create();
        return dept;
    }
}
