package com.julius.base.organization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.entity
 * @Author Julius Zhou
 * @Date 2020-05-03 21:18
 * @Description: 用户信息映射实体
 */

@Entity(name = "user")
@Data
@TableName(value = "user_info")
public class User implements Serializable {

    private static final long serialVersionUID = 6164351221169905763L;


    @Id
    @TableId(value = "id",type = IdType.AUTO)
    @Column(name = "id")
    //主键ID
    private Integer id;

    @Column(name = "uuid")
    //唯一标识
    private String uuid;

    @Column(name = "name")
    //用户名
    private String name;

    @Column(name = "nickname")
    //昵称
    private String nickname;

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


    @Column(name = "token")
    //用户令牌token
    private String token;

    @Column(name = "photo")
    //头像图片地址
    private String photo;

    @Column(name = "department_uuid")
    //部门UUID
    private String departmentUuid;

    @Column(name = "role_uuid")
    //权限uuid
    private String roleUuid;

    @Column(name = "id_card")
    //身份证号
    private String idCard;

    @Column(name = "enable_flag")
    //启动标签
    private Integer enableFlag;

    @Column(name = "delete_flag")
    //删除标记
    private Integer deleteFlag;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //创建时间
    private Date createTime;

    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //修改时间
    private Date updateTime;

}
