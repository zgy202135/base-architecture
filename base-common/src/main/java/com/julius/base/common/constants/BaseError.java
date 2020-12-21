package com.julius.base.common.constants;

/**
 * @Title: base-architecture
 * @Package com.julius.base.common.constants
 * @Author Julius Zhou
 * @Date 2020-05-04 10:06
 * @Description: 基础自定义异常
 */
public enum BaseError {

    PARAM_NOT_NULL(100100,"入参不能为空"),
    EMAIL_IS_NOT_VALID(100101,"邮箱不合法"),
    PASSWORD_IS_NOT_VALID(100102,"密码不合法")
    ;


    private Integer code;

    private String message;

    BaseError(Integer code,String message){
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
        return "BaseError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }}
