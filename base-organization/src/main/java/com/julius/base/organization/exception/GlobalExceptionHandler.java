package com.julius.base.organization.exception;

import com.julius.base.common.exception.RestExceptionResult;
import com.julius.base.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.exception
 * @Author Julius Zhou
 * @Date 2020-05-04 09:29
 * @Description: 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * @Description 处理自定义异常
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handlerServiceException(HttpServletRequest request, HttpServletResponse response,ServiceException e){
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        log.info("-------------------- handler custom exception:【ServiceException】 ---------------------");
        PrintWriter out = null;
        //处理自定义异常
        try{
            RestExceptionResult result = null;
            result = new RestExceptionResult(e.getCode(),e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.error("exception :{}",result.toString());
            out = response.getWriter();
            out.print(request.toString());
        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            if(out != null){
                out.close();
            }
        }
        return null;
    }
}
