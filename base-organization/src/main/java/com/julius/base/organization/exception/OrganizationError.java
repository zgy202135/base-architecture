package com.julius.base.organization.exception;


/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.exception
 * @Author Julius Zhou
 * @Date 2020-05-04 10:06
 * @Description: 用户自定义异常信息
 */
public enum  OrganizationError {

    USER_INFO_NOT_NULL(200100,"用户信息不能为空"),
    USER_INFO_IS_NOT_EXISTS(200101,"用户信息不存在")
    ;


    private Integer code;

    private String message;

    OrganizationError(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "OrganizationError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }}
