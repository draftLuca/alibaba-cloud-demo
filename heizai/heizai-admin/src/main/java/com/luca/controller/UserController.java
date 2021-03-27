package com.luca.controller;


import com.luca.entity.User;
import com.luca.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author luca
 * @since 2021-03-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/{id}")
    public String getServiceInfo(@PathVariable("id") Long id){
        User user = userService.getById(id);
        return user.toString();
    }

}
