package com.luca.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.sys.entity.Permission;
import com.luca.sys.mapper.PermissionMapper;
import com.luca.sys.service.IPermissionService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public Page<Permission> listPage(Page<Permission> page) {
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        return permissionMapper.selectPage(page, queryWrapper);
    }

    @Override
    public Permission get(Long id) {
        Permission permission = getById(id);
        return permission;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean create(Permission permission) {
        permission.setId(null);
        return save(permission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Permission permission) {
        Permission permissionOrigin = getById(permission.getId());
        if (ObjectUtils.isEmpty(permissionOrigin)) {
            return false;
        }

        return updateById(permission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(Long id) {
        Permission permissionOrigin = getById(id);
        if (ObjectUtils.isEmpty(permissionOrigin)) {
            return false;
        }
        return removeById(id);
    }
    
}
