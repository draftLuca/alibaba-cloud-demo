package com.luca.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.sys.entity.User;
import com.luca.sys.mapper.UserMapper;
import com.luca.sys.service.IUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luca
 * @since 2021-08-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Page<User> listPage(Page<User> page) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return userMapper.selectPage(page, queryWrapper);
    }

    @Override
    public User get(Long id) {
        User user = getById(id);
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean create(User user) {
        user.setId(null);
        return save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(User user) {
        User userOrigin = getById(user.getId());
        if (ObjectUtils.isEmpty(userOrigin)) {
            return false;
        }

        return updateById(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(Long id) {
        User userOrigin = getById(id);
        if (ObjectUtils.isEmpty(userOrigin)) {
            return false;
        }
        return removeById(id);
    }

    @Override
    public User getByUserName(String userName) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery(new User());
        userLambdaQueryWrapper.eq(User::getUsername, userName);
        return getOne(userLambdaQueryWrapper, false);
    }

}
