package com.luca.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("sys_resources")
@ApiModel(value = "Resources对象", description = "")
public class Resources implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "url")
    private String url;

    @JsonProperty(value = "permission")
    private String permission;

    @JsonProperty(value = "parent_id")
    private Long parentId;

    @JsonProperty(value = "sort")
    private Integer sort;

    @ApiModelProperty(value = "是否外部链接")
    @JsonProperty(value = "external")
    private Integer external;

    @JsonProperty(value = "available")
    private Integer available;

    @ApiModelProperty(value = "菜单图标")
    @JsonProperty(value = "icon")
    private String icon;

    @ApiModelProperty(value = "添加时间")
    @JsonProperty(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonProperty(value = "update_time")
    private LocalDateTime updateTime;


}
