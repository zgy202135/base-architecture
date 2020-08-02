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
 * @Date 2020-08-02 16:03
 * @Description: 部门实体对象
 */
@ApiModel(description = "部门实体对象")
public class DepartmentDTO implements Serializable {
    private static final long SERIALVERSIONID = 1L;

    @ApiModelProperty(value = "唯一标识")
    private String uuid;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "部门别称")
    private String aliasName;

    @ApiModelProperty(value = "父唯一标识")
    private String parentUuid;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "启用标志（0-启用，1-停用）",required = true)
    private Integer enableFlag;


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
        return "DepertmentDTO{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", parentUuid='" + parentUuid + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", enableFlag=" + enableFlag +
                '}';
    }
}
