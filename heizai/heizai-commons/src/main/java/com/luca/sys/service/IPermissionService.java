package com.luca.sys.service;

import com.luca.sys.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
public interface IPermissionService extends IService<Permission> {

    Page<Permission> listPage(Page<Permission> page);
    
    Permission get(Long id);

    boolean create(Permission permission);

    boolean update(Permission permission);
    
    boolean remove(Long id);
}
