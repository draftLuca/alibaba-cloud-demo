package com.luca.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.config.DepteEvent;
import com.luca.entity.Dept;
import com.luca.feign.admin.FUserService;
import com.luca.mapper.DeptMapper;
import com.luca.service.IDeptService;
import com.luca.utils.EventUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author luca
 * @since 2021-03-27
 */
@Slf4j
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    FUserService fUserService;

    @Override
    public String test(Long id) {
        String result = fUserService.getServiceInfo(id);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Dept create() {
        Dept dept = new Dept();
        dept.setName(RandomUtils.nextLong() + "部门");
        dept.setEnabled(true);
        EventUtils.publishEvent(new DepteEvent("创建了一个部门"));
        log.info("-------create dept--------------->" + dept.toString());
        return dept;
    }
}
