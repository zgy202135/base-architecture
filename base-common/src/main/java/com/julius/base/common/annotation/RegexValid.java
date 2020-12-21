package com.julius.base.common.annotation;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.julius.base.common.constants.BaseConstant;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Package: com.julius.base.common.annotation
 * @ClassName: RegexValid
 * @Author: Julius
 * @Description: 校验注解
 * @Date: 2020/8/6 19:06
 * @Version: 1.0
 * @see com.julius.base.common.constants.BaseConstant.RegexConstant
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD,ElementType.PARAMETER})
public @interface RegexValid {

    /**
     * @return a regex
     * @see com.julius.base.common.constants.BaseConstant.RegexConstant
     */
    @AliasFor(value = "name")
    String value() default "";


    /**
     * @return a regex
     * @see com.julius.base.common.constants.BaseConstant.RegexConstant
     */
    @AliasFor(value = "value")
    String name() default "";



}
