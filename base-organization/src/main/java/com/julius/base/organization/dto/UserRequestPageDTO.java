package com.julius.base.organization.dto;

import com.julius.base.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.dto
 * @Author Julius Zhou
 * @Date 2020-07-25 19:47
 * @Description: 用户信息分页请求
 */
@ApiModel(description = "用户信息分页请求")
public class UserRequestPageDTO extends RequestPage {


    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "性别（0-男，1-女，2-未知）",example = "2")
    private Integer sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserRequestPageDTO{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
