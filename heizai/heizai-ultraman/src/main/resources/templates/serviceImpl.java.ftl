package ${package.ServiceImpl};

import com.nayuan.core.common.ResultEnum;
import com.nayuan.core.exception.BusinessException;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.ObjectUtils;
import ${superServiceImplClassPackage};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Autowired
    ${table.mapperName} ${table.mapperName?uncap_first};

    @Override
    public Page<${entity}> listPage(Page<${entity}> page) {
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        return ${table.mapperName?uncap_first}.selectPage(page, queryWrapper);
    }

    @Override
    public ${entity} get(Long id) {
        ${entity} ${entity?uncap_first} = getById(id);
        return ${entity?uncap_first};
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean create(${entity} ${entity?uncap_first}) {
        ${entity?uncap_first}.setId(null);
        return save(${entity?uncap_first});
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(${entity} ${entity?uncap_first}) {
        ${entity} ${entity?uncap_first}Origin = getById(${entity?uncap_first}.getId());
        if (ObjectUtils.isEmpty(${entity?uncap_first}Origin)) {
            throw new BusinessException(ResultEnum.A0400);
        }

        ${entity?uncap_first}.setVersion(${entity?uncap_first}Origin.getVersion());
        return updateById(${entity?uncap_first});
    }
    
}
</#if>
