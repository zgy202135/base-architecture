package com.julius.base.common.dao;

import java.util.List;

/**
 * @Package: com.julius.base.common.dao
 * @ClassName: BaseDao
 * @Author: Julius
 * @Description: 基础持久层泛型接口
 * @Date: 2020/1/13 17:24
 * @Version: 1.0
 */
public interface BaseDao<T> {

    <T> List<T> insertPatch(String sql);

}
