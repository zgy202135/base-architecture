package com.julius.base.common.reflect;

import javax.persistence.Column;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.julius.base.common.reflect
 * @ClassName: BaseAnnotation
 * @Author: Julius
 * @Description: 基础注解处理对象
 * @Date: 2020/1/15 13:43
 * @Version: 1.0
 */
public class BaseAnnotation<T> {


    /**
     * @Description 获取类字段注解的某一属性值
     * @return
     */
    public <K,V extends Annotation> Map<String,String> getFieldAnnotationProperty(K k, V v){
        //获取所有字段
        Field[] fields = k.getClass().getDeclaredFields();
        Map<String,String> resultMap = new HashMap<>();
        if(fields != null){
            for(Field field : fields){
                //设置字段为可访问
                if(!field.isAccessible()){
                    field.setAccessible(true);
                }
                Column column =(Column) field.getAnnotation(v.getClass());
                resultMap.put(field.getName(),column.name());
            }
        }
        return resultMap;

    }
}
