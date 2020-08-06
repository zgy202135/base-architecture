package com.julius.base.common.utils;

import com.julius.base.common.page.ResponsePage;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: base-architecture
 * @Package com.julius.base.common.utils
 * @Author Julius Zhou
 * @Date 2020-07-26 10:15
 * @Description: 抽象数据类型转换工具类
 */
public abstract class AbstractDataTransformUtil<T> {


    /**
     * @Descpription 分页对象转换
     * @param page 分页数据
     * @param target 分页中目标实体类
     * @param currentPage 当前页
     * @param pageSize 每页记录数
     * @return
     */
    public <K,V> ResponsePage<V> poTransformDto(Page<K> page, Class<V> target, Integer currentPage, Integer pageSize){

        ResponsePage<V> result = new ResponsePage<>();
        result.setCurrentPage(currentPage);
        result.setPageSize(pageSize);
        if(page == null){
            result.setTotalPage(0);
            result.setTotalSize(0L);
            result.setList(new ArrayList<>());
            return result;
        }
        result.setTotalPage(page.getTotalPages());
        result.setTotalSize(page.getTotalElements());
        List<K> sourceList = page.getContent();
        if(ObjectUtils.isEmpty(sourceList)){
            result.setList(new ArrayList<>());
            return result;
        }
        List<V> targetList = new ArrayList<>(1<<4);
        targetList = poTransformDTOList(sourceList,target);
        result.setList(targetList);
        return result;
    }


    /**
     * @Description List对象转换
     * @param target
     * @param <K>
     * @param <V>
     * @return
     */
    public <K,V> List<V> poTransformDTOList(List<K> sourceList,Class<V> target){
        //对象转换
        List<V> targetList = new ArrayList<>(1<<4);
        for(int var1 = 0;var1 < sourceList.size();var1++){
            V targetV = newInstance(target);
            if(targetV == null){
                continue;
            }
            BeanUtils.copyProperties(sourceList.get(var1),targetV);
            targetList.add(targetV);
        }
        return targetList;
    }

    /**
     * @Description 初始化泛型对象
     * @param clazz
     * @param <V>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private <V> V newInstance(Class<V> clazz){
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
