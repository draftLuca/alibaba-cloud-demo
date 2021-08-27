package com.luca.sys.service;

import com.luca.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
public interface IUserService extends IService<User> {

    Page<User> listPage(Page<User> page);
    
    User get(Long id);

    boolean create(User user);

    boolean update(User user);
    
    boolean remove(Long id);
}
