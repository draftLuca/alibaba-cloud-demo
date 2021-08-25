package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    Page<${entity}> listPage(Page<${entity}> page);
    
    ${entity} get(Long id);

    boolean create(${entity} ${entity?uncap_first});

    boolean update(${entity} ${entity?uncap_first});
    
    boolean remove(Long id);
}
</#if>
