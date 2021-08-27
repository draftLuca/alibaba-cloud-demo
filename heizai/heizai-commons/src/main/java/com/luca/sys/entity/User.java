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
import java.time.LocalDate;
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
@TableName("sys_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty(value = "username")
    private String username;

    @ApiModelProperty(value = "登录密码")
    @JsonProperty(value = "password")
    private String password;

    @ApiModelProperty(value = "昵称")
    @JsonProperty(value = "nickname")
    private String nickname;

    @ApiModelProperty(value = "手机号")
    @JsonProperty(value = "mobile")
    private String mobile;

    @ApiModelProperty(value = "邮箱地址")
    @JsonProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "QQ")
    @JsonProperty(value = "qq")
    private String qq;

    @ApiModelProperty(value = "生日")
    @JsonProperty(value = "birthday")
    private LocalDate birthday;

    @ApiModelProperty(value = "性别")
    @JsonProperty(value = "gender")
    private Integer gender;

    @ApiModelProperty(value = "头像地址")
    @JsonProperty(value = "avatar")
    private String avatar;

    @ApiModelProperty(value = "超级管理员、管理员、普通用户")
    @JsonProperty(value = "user_type")
    private String userType;

    @ApiModelProperty(value = "注册IP")
    @JsonProperty(value = "reg_ip")
    private String regIp;

    @ApiModelProperty(value = "最近登录IP")
    @JsonProperty(value = "last_login_ip")
    private String lastLoginIp;

    @ApiModelProperty(value = "最近登录时间")
    @JsonProperty(value = "last_login_time")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "登录次数")
    @JsonProperty(value = "login_count")
    private Integer loginCount;

    @ApiModelProperty(value = "用户备注")
    @JsonProperty(value = "remark")
    private String remark;

    @ApiModelProperty(value = "用户状态")
    @JsonProperty(value = "status")
    private Integer status;

    @ApiModelProperty(value = "注册时间")
    @JsonProperty(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonProperty(value = "update_time")
    private LocalDateTime updateTime;


}
