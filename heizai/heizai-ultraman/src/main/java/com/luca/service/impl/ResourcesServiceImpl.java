package com.luca.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.sys.entity.Resources;
import com.luca.sys.entity.RoleResources;
import com.luca.sys.entity.UserRole;
import com.luca.sys.mapper.ResourcesMapper;
import com.luca.sys.service.IResourcesService;
import com.luca.sys.service.IRoleResourcesService;
import com.luca.sys.service.IUserRoleService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luca
 * @since 2021-08-25
 */
@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, Resources> implements IResourcesService {

    @Autowired
    ResourcesMapper resourcesMapper;

    @Autowired
    IRoleResourcesService iRoleResourcesService;

    @Autowired
    IUserRoleService iUserRoleService;

    @Override
    public Page<Resources> listPage(Page<Resources> page) {
        QueryWrapper<Resources> queryWrapper = new QueryWrapper<>();
        return resourcesMapper.selectPage(page, queryWrapper);
    }

    @Override
    public Resources get(Long id) {
        Resources resources = getById(id);
        return resources;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean create(Resources resources) {
        resources.setId(null);
        return save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Resources resources) {
        Resources resourcesOrigin = getById(resources.getId());
        if (ObjectUtils.isEmpty(resourcesOrigin)) {
            return false;
        }

        return updateById(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(Long id) {
        Resources resourcesOrigin = getById(id);
        if (ObjectUtils.isEmpty(resourcesOrigin)) {
            return false;
        }
        return removeById(id);
    }

    @Override
    public List<Resources> listByUserId(Long userId) {
        List<Long> roleIds = iUserRoleService.list(Wrappers.lambdaQuery(new UserRole()).eq(UserRole::getUserId, userId)).stream().map(UserRole::getRoleId).collect(Collectors.toList());
        if (ObjectUtils.isNotEmpty(roleIds)) {
            List<Long> resourcesIds = iRoleResourcesService.list(Wrappers.lambdaQuery(new RoleResources()).in(RoleResources::getRoleId, roleIds)).stream().map(RoleResources::getResourcesId).collect(Collectors.toList());
            if (ObjectUtils.isNotEmpty(resourcesIds)) {
                List<Resources> resources = listByIds(resourcesIds);
                return resources;
            }
        }
        return null;
    }

}
