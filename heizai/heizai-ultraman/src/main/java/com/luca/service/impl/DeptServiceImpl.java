package com.luca.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.entity.Dept;
import com.luca.feign.admin.FUserService;
import com.luca.mapper.DeptMapper;
import com.luca.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author luca
 * @since 2021-03-27
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    FUserService fUserService;

    @Override
    public String test(Long id) {
        String result = fUserService.getServiceInfo(id);
        return result;
    }
}
