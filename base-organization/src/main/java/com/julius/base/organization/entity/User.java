package com.julius.base.organization.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.entity
 * @Author Julius Zhou
 * @Date 2020-05-03 21:18
 * @Description: 用户信息映射实体
 */

@Table(name = "user_info")
@Entity(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //主键ID
    private Integer id;

    @Column(name = "uuid")
    //唯一标识
    private String uuid;

    @Column(name = "name")
    //用户名
    private String name;

    @Column(name = "sex")
    //性别
    private String sex;

    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    //出生日期
    private Date birthDate;

    @Column(name = "login_name")
    //登录名
    private String loginName;

    @Column(name = "password")
    //密码
    private String password;

    @Column(name = "telephone")
    //电话
    private String telephone;

    @Column(name = "mobile")
    //手机号码
    private String mobile;

    @Column(name = "address")
    //家庭住址
    private String address;

    @Column(name = "email")
    //邮箱
    private String email;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //创建时间
    private Date createTime;

    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //修改时间
    private Date updateTime;

    @Column(name = "delete_flag")
    //删除标记
    private Integer deleteFlag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "User{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
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
