package com.luca.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.pojo.entity.User;
import com.luca.mapper.UserMapper;
import com.luca.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author luca
 * @since 2021-03-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;
}
