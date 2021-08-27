package com.luca.sys.service;

import com.luca.sys.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
public interface IUserRoleService extends IService<UserRole> {

    Page<UserRole> listPage(Page<UserRole> page);
    
    UserRole get(Long id);

    boolean create(UserRole userRole);

    boolean update(UserRole userRole);
    
    boolean remove(Long id);
}
