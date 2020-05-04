package com.julius.base.organization.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
public class UserDTO implements Serializable {

    private static final long SERAILVERSIONID = 1;

    @ApiModelProperty(value = "唯一标识")
    private String uuid;

    @ApiModelProperty(value = "用户名")
    private String name;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "删除标记")
    private Integer deleteFlag;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate=" + birthDate +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
