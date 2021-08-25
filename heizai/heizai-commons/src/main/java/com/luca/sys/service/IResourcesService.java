package com.luca.sys.service;

import com.luca.sys.entity.Resources;
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
public interface IResourcesService extends IService<Resources> {

    Page<Resources> listPage(Page<Resources> page);
    
    Resources get(Long id);

    boolean create(Resources resources);

    boolean update(Resources resources);
    
    boolean remove(Long id);
}
