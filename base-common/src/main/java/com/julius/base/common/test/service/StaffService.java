package com.julius.base.common.test.service;

import com.julius.base.common.test.entity.Staff;

import java.util.List;

/**
 * @Package: com.julius.base.common.test.service.impl
 * @ClassName: StaffService
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/1/14 10:36
 * @Version: 1.0
 */
public interface StaffService {

    Staff add(Staff staff);

    Staff update(Staff staff);

    String delete(String id);

    List<Staff> findAll();

    List<Staff> findByPage(Integer currentPage,Integer pageSize);

    List<Staff> findAllByCondition(String name, Integer age, String departmentId);

    long countByCondition(String name, Integer age, String departmentId);
}
