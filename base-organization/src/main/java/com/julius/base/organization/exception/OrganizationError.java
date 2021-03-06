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
    USER_INFO_IS_NOT_EXISTS(200101,"用户信息不存在"),
    USER_UUID_NOT_NULL(200102,"用户唯一标识不能为空"),
    DEPARTMENT_INTO_NOT_NULL(200103,"部门信息不能为空"),
    DEPARTMENT_UUID_NOT_NULL(200104,"部门唯一标识不能为空"),
    DEPARTMENT_INFO_IS_NOT_EXISTS(200105,"部门信息不存在"),
    PAGE_PARAMETER_NOT_NULL(200106,"分页条件不能为空")
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
