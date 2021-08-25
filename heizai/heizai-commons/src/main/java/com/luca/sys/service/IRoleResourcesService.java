package com.luca.sys.service;

import com.luca.sys.entity.RoleResources;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luca
 * @since 2021-08-25
 */
public interface IRoleResourcesService extends IService<RoleResources> {

    Page<RoleResources> listPage(Page<RoleResources> page);
    
    RoleResources get(Long id);

    boolean create(RoleResources roleResources);

    boolean update(RoleResources roleResources);
    
    boolean remove(Long id);
}
