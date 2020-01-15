package com.julius.base.common.test.dao;

import com.julius.base.common.dao.BaseDao;
import com.julius.base.common.test.entity.Staff;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.julius.base.common.test.dao
 * @ClassName: StaffDao
 * @Author: Julius
 * @Description: 员工信息持久层
 * @Date: 2020/1/14 10:19
 * @Version: 1.0
 */
@Repository
public interface StaffDao extends BaseDao<Staff> ,JpaRepository<Staff,String>{

    /**
     * @Description 带有排序的条件查询
     * @param name
     * @param age
     * @param departmentId
     * @param sort
     * @return
     */
    List<Staff> findAllByCondition(String name, Integer age, String departmentId,Sort sort);


    /**
     * @Description 按照条件统计
     * @param name
     * @param age
     * @param departmentId
     * @return
     */
    long countByCondition(String name ,Integer age , String departmentId);
}
