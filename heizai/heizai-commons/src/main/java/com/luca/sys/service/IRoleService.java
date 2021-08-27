package com.luca.sys.service;

import com.luca.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luca
 * @since 2021-08-25
 */
public interface IRoleService extends IService<Role> {

    Page<Role> listPage(Page<Role> page);
    
    Role get(Long id);

    boolean create(Role role);

    boolean update(Role role);
    
    boolean remove(Long id);

    /**
     * 获取用户的角色
     *
     * @param userId
     * @return
     */
    List<Role> listRolesByUserId(Long userId);
}
