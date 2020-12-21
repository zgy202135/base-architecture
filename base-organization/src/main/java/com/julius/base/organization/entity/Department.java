package com.julius.base.organization.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.entity
 * @Author Julius Zhou
 * @Date 2020-08-02 15:47
 * @Description: 部门实体映射类
 */
@Entity(name = "department")
@Table(name = "department_info")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //主键ID
    private Integer id;

    //唯一标识
    private String uuid;

    //部门名称
    private String name;

    //部门别称
    private String aliasName;

    //父ID
    private Integer parentId;

    //父唯一标识
    private String parentUuid;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    //启用标志（0-启用，1-停用）
    private Integer enableFlag;

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

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
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

    public Integer getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", parentId=" + parentId +
                ", parentUuid='" + parentUuid + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", enableFlag=" + enableFlag +
                '}';
    }
}
