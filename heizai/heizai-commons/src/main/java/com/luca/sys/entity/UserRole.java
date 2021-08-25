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
@TableName("sys_user_role")
@ApiModel(value = "UserRole对象", description = "")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty(value = "user_id")
    private Long userId;

    @JsonProperty(value = "role_id")
    private Long roleId;

    @ApiModelProperty(value = "添加时间")
    @JsonProperty(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonProperty(value = "update_time")
    private LocalDateTime updateTime;


}
