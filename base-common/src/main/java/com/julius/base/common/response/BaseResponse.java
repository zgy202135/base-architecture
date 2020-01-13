package com.julius.base.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.julius.base.common.response
 * @ClassName: BaseResponse
 * @Author: Julius
 * @Description: 响应基础数据
 * @Date: 2020/1/13 16:47
 * @Version: 1.0
 */
@ApiModel(value = "响应基础数据")
public class BaseResponse<T> {
    enum Response{
        SUCCESS(200,"请求成功"),
        ERROR(500,"请求失败");
        private Integer code;
        private String message;
        Response(Integer code,String message){
            this.code = code;
            this.message = message;
        }
        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    @ApiModelProperty(value = "响应编号")
    private String code;

    @ApiModelProperty(value = "响应描述")
    private String message;

    @ApiModelProperty(value = "响应数据")
    private List<T> list;

    BaseResponse(){
        this.list = new ArrayList<>();
    }

    BaseResponse(String code,String message,List<T> list){
        this.code = code;
        this.message = message;
        this.list = list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
