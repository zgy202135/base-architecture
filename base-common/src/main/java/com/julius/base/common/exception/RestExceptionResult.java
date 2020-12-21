package com.julius.base.common.exception;

import com.julius.base.common.constants.BaseConstant;
import org.springframework.util.StringUtils;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.exception
 * @Author Julius Zhou
 * @Date 2020-05-04 09:44
 * @Description: 错误响应实体
 */
public class RestExceptionResult {

    /**
     * 响应Code
     */
    private Integer code;

    /**
     * 响应描述
     */
    private String message;

    public RestExceptionResult(Integer code, String message){
        this.code = code;
        this.message = message;
        if(StringUtils.isEmpty(message)){
            this.message = BaseConstant.UNKNOWN_EXCEPTION;
        }
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

    @Override
    public String toString() {
        return "RestExceptionResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
