package com.luca.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.sys.entity.RoleResources;
import com.luca.sys.mapper.RoleResourcesMapper;
import com.luca.sys.service.IRoleResourcesService;
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
public class RoleResourcesServiceImpl extends ServiceImpl<RoleResourcesMapper, RoleResources> implements IRoleResourcesService {

    @Autowired
    RoleResourcesMapper roleResourcesMapper;

    @Override
    public Page<RoleResources> listPage(Page<RoleResources> page) {
        QueryWrapper<RoleResources> queryWrapper = new QueryWrapper<>();
        return roleResourcesMapper.selectPage(page, queryWrapper);
    }

    @Override
    public RoleResources get(Long id) {
        RoleResources roleResources = getById(id);
        return roleResources;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean create(RoleResources roleResources) {
        roleResources.setId(null);
        return save(roleResources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(RoleResources roleResources) {
        RoleResources roleResourcesOrigin = getById(roleResources.getId());
        if (ObjectUtils.isEmpty(roleResourcesOrigin)) {
            return false;
        }

        return updateById(roleResources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(Long id) {
        RoleResources roleResourcesOrigin = getById(id);
        if (ObjectUtils.isEmpty(roleResourcesOrigin)) {
            return false;
        }
        return removeById(id);
    }
    
}
