package com.luca.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.sys.entity.RolePermission;
import com.luca.sys.mapper.RolePermissionMapper;
import com.luca.sys.service.IRolePermissionService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色资源表 服务实现类
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public Page<RolePermission> listPage(Page<RolePermission> page) {
        QueryWrapper<RolePermission> queryWrapper = new QueryWrapper<>();
        return rolePermissionMapper.selectPage(page, queryWrapper);
    }

    @Override
    public RolePermission get(Long id) {
        RolePermission rolePermission = getById(id);
        return rolePermission;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean create(RolePermission rolePermission) {
        rolePermission.setId(null);
        return save(rolePermission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(RolePermission rolePermission) {
        RolePermission rolePermissionOrigin = getById(rolePermission.getId());
        if (ObjectUtils.isEmpty(rolePermissionOrigin)) {
            return false;
        }

        return updateById(rolePermission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(Long id) {
        RolePermission rolePermissionOrigin = getById(id);
        if (ObjectUtils.isEmpty(rolePermissionOrigin)) {
            return false;
        }
        return removeById(id);
    }
    
}
