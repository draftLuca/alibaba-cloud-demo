package com.luca.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author luca
 * @since 2021-08-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_resources")
@ApiModel(value = "RoleResources对象", description = "")
public class RoleResources implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty(value = "role_id")
    private Long roleId;

    @JsonProperty(value = "resources_id")
    private Long resourcesId;

    @ApiModelProperty(value = "添加时间")
    @JsonProperty(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonProperty(value = "update_time")
    private LocalDateTime updateTime;


}
