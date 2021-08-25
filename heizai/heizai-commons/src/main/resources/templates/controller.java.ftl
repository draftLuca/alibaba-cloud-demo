package ${package.Controller};

import com.luca.util.ResultEntity;
import com.luca.pojo.vo.ResponseVO;
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
@Api(tags = "${table.comment!}")
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

    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页号", dataTypeClass = Long.class),
        @ApiImplicitParam(name = "size", value = "每页显示条数", dataTypeClass = Long.class)
    })
    @PostMapping("/query")
    public ResponseVO<Page<${entity}>> query(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "10") Long size) {
        Page<${entity}> page = new Page<>(current, size);
        Page<${entity}> ${entity?uncap_first}Page = ${table.serviceName?uncap_first}.listPage(page);
        return ResultUtil.success(${entity?uncap_first}Page);
    }

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping("")
    public ResponseVO<${entity}> create(@RequestBody ${entity} ${entity?uncap_first}) {
        ${table.serviceName?uncap_first}.create(${entity?uncap_first});
        return ResultUtil.success(${entity?uncap_first});
    }

    @ApiOperation(value = "获取", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseVO<${entity}> get(@PathVariable Long id) {
        return ResultUtil.success(${table.serviceName?uncap_first}.get(id));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping("/{id}")
    public ResponseVO<String> update(@PathVariable Long id, @RequestBody ${entity} ${entity?uncap_first}) {
        ${entity?uncap_first}.setId(id);
        return ResultUtil.success(${table.serviceName?uncap_first}.update(${entity?uncap_first}));
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseVO<String> remove(@PathVariable Long id) {
        return ResultUtil.success(${table.serviceName?uncap_first}.remove(id));
    }

}
</#if>
