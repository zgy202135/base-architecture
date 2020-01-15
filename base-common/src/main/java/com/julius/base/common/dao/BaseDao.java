package com.julius.base.common.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.julius.base.common.dao
 * @ClassName: BaseDao
 * @Author: Julius
 * @Description: EntityManager 基础持久层泛型接口
 * @Date: 2020/1/13 17:24
 * @Version: 1.0
 */
public interface BaseDao<T> {


    /**
     * @Description insert
     * @param t
     * @return
     */
    public T add (T t);

    /**
     * @Description delete
     * @param t
     * @param <T>
     * @return
     */
    public <T extends Serializable> T delete (T t);


    /**
     * @Description update
     * @param t
     * @return
     */
    public T update (T t);


    /**
     * @Description 查询所有
     * @return
     */
    public List<T> findAll();

    /**
     * @Description 按照条件查询所有
     * @param jpql
     * @param parameterMap
     * @return
     */
    public List<T> findByConditions(String jpql, Map<String,Object> parameterMap, Sort sort);

    /**
     * @Description 普通的分页查询
     * @param firstIndex
     * @param maxResults
     * @return
     */
    public List<T> findByPage(Integer firstIndex,Integer maxResults);

    /**
     * @Description 按照条件统计
     * @param jpql
     * @param parameterMap
     * @return
     */
    public long countByCondition(String jpql,Map<String,Object> parameterMap);


    /**
     * @Description 复杂分页查询
     * @param firstIndex
     * @param maxResults
     * @param jpql
     * @param parameterMap
     * @param sort
     * @return
     */
    public List<T> findByConditionPage(Integer firstIndex,Integer maxResults,String jpql,Map<String,Object> parameterMap,Sort sort);
}
