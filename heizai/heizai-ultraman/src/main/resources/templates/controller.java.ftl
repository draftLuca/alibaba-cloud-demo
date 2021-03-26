package ${package.Controller};

import com.nayuan.core.common.ResultEntity;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    ${table.serviceName} ${table.serviceName?uncap_first};

    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页号", dataTypeClass = Long.class),
        @ApiImplicitParam(name = "size", value = "每页显示条数", dataTypeClass = Long.class)
    })
    @PostMapping("/query")
    public ResultEntity<Page<${entity}>> query(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "10") Long size) {
        Page<${entity}> page = new Page<>(current, size);
        Page<${entity}> ${entity?uncap_first}Page = ${table.serviceName?uncap_first}.listPage(page);
        return ResultEntity.ok(${entity?uncap_first}Page);
    }

    @PostMapping("")
    public ResultEntity<${entity}> create(@RequestBody @Valid ${entity} ${entity?uncap_first}) {
        ${table.serviceName?uncap_first}.create(${entity?uncap_first});
        return ResultEntity.ok(${entity?uncap_first});
    }

    @GetMapping("/{id}")
    public ResultEntity<${entity}> get(@PathVariable Long id) {
        return ResultEntity.ok(${table.serviceName?uncap_first}.get(id));
    }

    @PutMapping("/{id}")
    public ResultEntity<String> update(@PathVariable Long id, @RequestBody @Valid ${entity} ${entity?uncap_first}) {
        ${entity?uncap_first}.setId(id);
        return ResultEntity.ret(${table.serviceName?uncap_first}.update(${entity?uncap_first}));
    }

    @DeleteMapping("/{id}")
    public ResultEntity<String> remove(@PathVariable Long id) {
        return ResultEntity.ret(${table.serviceName?uncap_first}.removeById(id));
    }

}
</#if>
