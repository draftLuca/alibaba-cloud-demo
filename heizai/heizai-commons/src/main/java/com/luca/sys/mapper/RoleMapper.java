package com.luca.sys.mapper;

import com.luca.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据User查询Role
     * @param account
     * @return java.util.List<com.wang.model.RoleDto>
     * @author dolyw.com
     * @date 2018/8/31 11:30
     */
    List<Role> findRoleByUser(String account);
}
