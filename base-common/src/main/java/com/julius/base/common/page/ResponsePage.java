package com.julius.base.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.julius.base.common.page
 * @ClassName: ResponsePage
 * @Author: Julius
 * @Description: 分页响应数据（泛型类）
 * @Date: 2020/1/13 15:46
 * @Version: 1.0
 */
@ApiModel(value = "分页响应数据")
public class ResponsePage<T> {

    @ApiModelProperty(value = "当前页",example = "从0开始")
    private Integer currentPage;

    @ApiModelProperty(value = "每页记录数",example = "数值")
    private Integer pageSize;

    @ApiModelProperty(value = "总条数")
    private Integer totalSize = 0;

    @ApiModelProperty(value = "总页数")
    private Integer totalPage;

    @ApiModelProperty(value = "数据")
    private List<T> list;


    ResponsePage(){
        this.list = new ArrayList<>();
    }

    ResponsePage(Integer currentPage,Integer pageSize,Integer totalPage,Integer totalSize,List<T> list){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalSize = totalSize;
        this.list = list;
    }


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

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
