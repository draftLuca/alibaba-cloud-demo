package com.luca.sys.service;

import com.luca.sys.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 角色资源表 服务类
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
public interface IRolePermissionService extends IService<RolePermission> {

    Page<RolePermission> listPage(Page<RolePermission> page);
    
    RolePermission get(Long id);

    boolean create(RolePermission rolePermission);

    boolean update(RolePermission rolePermission);
    
    boolean remove(Long id);
}
