package com.luca.sys.mapper;

import com.luca.sys.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luca.sys.entity.Role;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author luca
 * @since 2021-08-27
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据Role查询Permission
     * @param role
     * @return java.util.List<com.wang.model.PermissionDto>
     * @author dolyw.com
     * @date 2018/8/31 11:30
     */
    List<Permission> findPermissionByRole(Role role);
}
