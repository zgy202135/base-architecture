package com.julius.base.common.dao.impl;

import com.julius.base.common.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Package: com.julius.base.common.dao.impl
 * @ClassName: AbstractBaseDao
 * @Author: Julius
 * @Description: 基础持久层接口 定义为abstract 该类不应该被实例化
 * @Date: 2020/1/13 17:25
 * @Version: 1.0
 */
public abstract class AbstractBaseDao<T> implements BaseDao<T> {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public <T> List<T> insertPatch(String sql) {
        return null;
    }

}
