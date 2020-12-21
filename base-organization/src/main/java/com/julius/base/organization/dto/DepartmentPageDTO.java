package com.julius.base.organization.dto;

import com.julius.base.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package: com.julius.base.organization.dto
 * @ClassName: DepartmentPageDTO
 * @Author: Julius
 * @Description: 部门信息分页查询实体
 * @Date: 2020/8/6 18:31
 * @Version: 1.0
 */
@ApiModel(value = "部门信息查询实体")
public class DepartmentPageDTO extends RequestPage {

    @ApiModelProperty(value = "部门名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentPageDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
