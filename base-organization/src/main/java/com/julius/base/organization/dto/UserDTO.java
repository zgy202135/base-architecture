package com.julius.base.organization.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.dto
 * @Author Julius Zhou
 * @Date 2020-05-03 22:22
 * @Description: 用户基本信息DTO
 */

@ApiModel(description = "用户基本信息")
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1877165717562871973L;


    @ApiModelProperty(value = "唯一标识")
    private String uuid;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "性别")
    private String sex;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期")
    private Date birthDate;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String telephone;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "家庭住址")
    private String address;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "用户令牌token")
    private String token;

    @ApiModelProperty(value = "头像图片地址")
    private String photo;

    @ApiModelProperty(value = "部门UUID")
    private String departmentUuid;

    @ApiModelProperty(value = "权限uuid")
    private String roleUuid;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "启动标签")
    private Integer enableFlag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "删除标记",example = "0")
    private Integer deleteFlag;

}
