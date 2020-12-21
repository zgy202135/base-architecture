package com.julius.base.common.annotation;

import com.julius.base.common.constants.BaseConstant;
import com.julius.base.common.exception.ServiceException;
import com.julius.base.common.utils.BaseRegexUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Package: com.julius.base.common.annotation
 * @ClassName: RegexValidAspect
 * @Author: Julius
 * @Description: 校验不合法参数 切面方法
 * @Date: 2020/8/6 19:15
 * @Version: 1.0
 */
@Aspect
@Component
public class RegexValidAspect {

    private static final Logger log = LoggerFactory.getLogger(RegexValidAspect.class);


    @Autowired
    private BaseRegexUtil baseRegexUtil;

    /**
     * 基于自定义注解的校验切入点
     */
    @Pointcut(value = "@annotation(com.julius.base.common.annotation.RegexValid)")
    public void regexPoint(){}


    /**
     * 前置处理
     * @param joinPoint
     */
    @Before(value = "regexPoint()")
    public void beforeRegex(ProceedingJoinPoint joinPoint)throws ServiceException{
        log.info("This is a around method to regex param");

        Object result = null;
        //获取接口签名
        Signature signature = joinPoint.getSignature();
        //获取方法参数名和值
        MethodSignature methodSignature =(MethodSignature) signature;
        Method method = methodSignature.getMethod();

        //todo 如何解析@RegexValid注解中的value和name值
        //获取注解
        Annotation[] annotations = method.getAnnotations();
        RegexValid regexValid = null;
        tagOne:for(Annotation annotation :annotations){
            if(annotation instanceof RegexValid){
                regexValid =(RegexValid) annotation;
                break tagOne;
            }
        }
        if(regexValid == null){
            return;
        }
        String regex = StringUtils.isEmpty(regexValid.value())?regexValid.name():regexValid.value();
        log.info("annotation value is :{}",regex);


        Boolean regexResult = false;
        if(BaseConstant.RegexConstant.EMAIL_REGEX.equals(regex)){
            regexResult = baseRegexUtil.regexEmail(regex);
        }
        if(BaseConstant.RegexConstant.MOBILE_REGEX.equals(regex)){

        }
        if(BaseConstant.RegexConstant.PASSWORD_REGEX.equals(regex)){

        }
        if(BaseConstant.RegexConstant.TELEPHONE_REGEX.equals(regex)){

        }

    }

}
