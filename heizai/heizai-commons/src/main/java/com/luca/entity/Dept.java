package com.luca.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author luca
 * @since 2021-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Dept对象", description="部门")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "上级部门")
    private Long pid;

    @ApiModelProperty(value = "状态")
    private Boolean enabled;

    @ApiModelProperty(value = "创建日期")
    private LocalDateTime createTime;


}
