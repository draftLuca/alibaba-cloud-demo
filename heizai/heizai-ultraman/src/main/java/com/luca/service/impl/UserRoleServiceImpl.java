package com.luca.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.sys.entity.UserRole;
import com.luca.sys.mapper.UserRoleMapper;
import com.luca.sys.service.IUserRoleService;
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
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public Page<UserRole> listPage(Page<UserRole> page) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        return userRoleMapper.selectPage(page, queryWrapper);
    }

    @Override
    public UserRole get(Long id) {
        UserRole userRole = getById(id);
        return userRole;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean create(UserRole userRole) {
        userRole.setId(null);
        return save(userRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(UserRole userRole) {
        UserRole userRoleOrigin = getById(userRole.getId());
        if (ObjectUtils.isEmpty(userRoleOrigin)) {
            return false;
        }

        return updateById(userRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(Long id) {
        UserRole userRoleOrigin = getById(id);
        if (ObjectUtils.isEmpty(userRoleOrigin)) {
            return false;
        }
        return removeById(id);
    }
    
}
