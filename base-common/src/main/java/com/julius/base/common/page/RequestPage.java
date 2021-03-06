package com.julius.base.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Package: com.julius.base.common.page
 * @ClassName: RequestPage
 * @Author: Julius
 * @Description: 分页请求
 * @Date: 2020/1/13 15:42
 * @Version: 1.0
 */
@ApiModel(value = "分页请求")
public class RequestPage implements Serializable {

    private static final long SERIALVERSIONID = 1L;

    @ApiModelProperty(value = "当前页",example = "0",required = true)
    private Integer currentPage = 0;

    @ApiModelProperty(value = "分页大小",example = "10",required = true)
    private Integer pageSize = 10;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
