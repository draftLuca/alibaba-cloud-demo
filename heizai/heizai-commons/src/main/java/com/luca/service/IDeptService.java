package com.luca.service;

import com.luca.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 部门 服务类
 * </p>
 *
 * @author luca
 * @since 2021-03-27
 */
public interface IDeptService extends IService<Dept> {

    public String test(Long id);
}
