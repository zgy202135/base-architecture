package com.julius.base.organization.exception;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.exception
 * @Author Julius Zhou
 * @Date 2020-05-04 09:22
 * @Description: 自定义异常
 */
public class ServiceException extends Exception {


    /**
     * 异常编号
     */
    private Integer code;


    /**
     * 异常描述
     */
    private String message;

    ServiceException(){
        super();
    }
    ServiceException(Integer code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    ServiceException(String message){
        super(message);
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
