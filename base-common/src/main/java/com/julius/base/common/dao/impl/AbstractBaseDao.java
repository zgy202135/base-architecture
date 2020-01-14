package com.julius.base.common.dao.impl;

import com.julius.base.common.dao.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.julius.base.common.dao.impl
 * @ClassName: AbstractBaseDao
 * @Author: Julius
 * @Description: 基础持久层接口 定义为abstract 该类不应该被实例化
 * @Date: 2020/1/13 17:25
 * @Version: 1.0
 */
@Transactional
public abstract class AbstractBaseDao<T> implements BaseDao<T> {

    private static final Logger log = LoggerFactory.getLogger(AbstractBaseDao.class);

    @PersistenceContext
    private EntityManager manager;

    public Class<T> clazz = null;

    public AbstractBaseDao(){
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    /**
     * @param t
     * @return
     * @Description insert
     */
    @Override
    public T add(T t) {
        manager.persist(t);
        return t;
    }

    /**
     * @param k
     * @return
     * @Description delete
     */
    @Override
    public <K extends Serializable> K delete(K k) {
        T t = manager.getReference(clazz,k);
        manager.remove(t);
        return k;
    }


    /**
     * @param t
     * @return
     * @Description update
     */
    @Override
    public T update(T t) {
        t = manager.merge(t);
        return t;
    }

    /**
     * @return
     * @Description 查询所有
     */
    @Override
    public List<T> findAll() {
        List<T> result = new ArrayList<>();
        System.out.println(clazz.getSimpleName());
        result = manager.createQuery("from "+clazz.getSimpleName()).getResultList();
        return result;
    }

    /**
     * @param jpql
     * @param parameterMap
     * @return
     * @Description 按照条件查询所有(单表+单排序 基于JPQL)
     */
    @Override
    public List<T> findByConditions(String jpql, Map<String, Object> parameterMap, Sort sort) {
        Assert.notNull(jpql,"jpql must not be null");
        Assert.notNull(parameterMap,"parameter list must not be null");

        //处理排序
        jpql = jpql + joinSort(sort);
        Query query = manager.createQuery(jpql);
        if(parameterMap != null && parameterMap.size() != 0){
            for(Map.Entry<String,Object> entry : parameterMap.entrySet()){
                query.setParameter(entry.getKey(),entry.getValue());
            }
        }
        List<T> result = new ArrayList<>();
        result = query.getResultList();
        return result;
    }

    /**
     * @param firstIndex
     * @param maxResults
     * @return
     * @Description 普通的分页查询
     */
    @Override
    public List<T> findByPage(Integer firstIndex, Integer maxResults) {
        Assert.notNull(firstIndex,"firstIndex must not be null");
        Assert.notNull(maxResults,"maxResults must not be null");
        return manager.createQuery("from " + clazz.getSimpleName()).setFirstResult(firstIndex).setMaxResults(maxResults).getResultList();
    }

    /**
     * @param jpql
     * @param parameterMap
     * @return
     * @Description 按照条件统计总条数（基于JPQL）
     */
    @Override
    public long countByCondition(String jpql, Map<String, Object> parameterMap) {
        Assert.notNull(jpql,"jpql must not be null");
        Query query = manager.createQuery(jpql);
        if(!ObjectUtils.isEmpty(parameterMap)){
            for(Map.Entry<String,Object> entry : parameterMap.entrySet()){
                query.setParameter(entry.getKey(),entry.getValue());
            }
        }

        return 0;
    }

    /**
     * @Description 统计全部数量
     * @return
     */
    public long count(){
        long totalSize = (Long)manager.createQuery("select count(*) from " + clazz.getSimpleName()).getSingleResult();
        return totalSize;
    }


    /**
     * @Description 拼接排序 -- 基于JPQL
     * @param sort
     * @return
     */
    private String joinSort(Sort sort){
        if(sort == null){
            return new String();
        }
        StringBuffer orderBy = new StringBuffer(" order by ");
        for(Sort.Order order : sort){
            if(order.isDescending()){
                log.info("sort field {}",order.getProperty());
                orderBy.append(order.getProperty());
                orderBy.append(" desc , ");
            }
            if(order.isAscending()){
                log.info("sort field {}",order.getProperty());
                orderBy.append(order.getProperty());
                orderBy.append(" asc , ");
            }
        }
        String result = orderBy.toString();
        result = result.substring(0,result.length()-2);
        return result;
    }

}
