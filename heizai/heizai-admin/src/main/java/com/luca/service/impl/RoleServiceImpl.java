package com.luca.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.sys.entity.Role;
import com.luca.sys.mapper.RoleMapper;
import com.luca.sys.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Page<Role> listPage(Page<Role> page) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        return roleMapper.selectPage(page, queryWrapper);
    }

    @Override
    public Role get(Long id) {
        Role role = getById(id);
        return role;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean create(Role role) {
        role.setId(null);
        return save(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Role role) {
        Role roleOrigin = getById(role.getId());
        if (ObjectUtils.isEmpty(roleOrigin)) {
            return false;
        }

        return updateById(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(Long id) {
        Role roleOrigin = getById(id);
        if (ObjectUtils.isEmpty(roleOrigin)) {
            return false;
        }
        return removeById(id);
    }
    
}
