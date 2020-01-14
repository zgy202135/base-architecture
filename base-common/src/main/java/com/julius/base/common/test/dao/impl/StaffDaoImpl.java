package com.julius.base.common.test.dao.impl;

import com.julius.base.common.dao.impl.AbstractBaseDao;
import com.julius.base.common.test.entity.Staff;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.julius.base.common.test.dao.impl
 * @ClassName: StaffDaoImpl
 * @Author: Julius
 * @Description: 持久层实现
 * @Date: 2020/1/14 10:22
 * @Version: 1.0
 */
@Repository
public class StaffDaoImpl extends AbstractBaseDao<Staff>{


    /**
     * @Description 实现方法(简单查询基于JPQL)
     * @param name
     * @param age
     * @param departmentId
     * @return
     */
    public List<Staff> findAllByCondition(String name, Integer age, String departmentId,Sort sort){
        StringBuffer jpql = new StringBuffer("select a from Staff a where 1=1");
        Map<String,Object> parameterMap = new HashMap<>();
        if(!StringUtils.isEmpty(name)){
            jpql.append(" and a.name like :name ");
            parameterMap.put("name","%"+name.trim()+"%");
        }
        if(age != null && age >= 0){
            jpql.append(" and a.age = :age ");
            parameterMap.put("age",age);
        }
        if(!StringUtils.isEmpty(departmentId)){
            jpql.append(" and a.departmentId = :departmentId");
            parameterMap.put("departmentId",departmentId.trim());
        }
        //处理排序
        List<Staff> list = findByConditions(jpql.toString(),parameterMap,sort);
        return list;
    }


}
