package com.julius.base.study.test.service.impl;

import com.julius.base.study.test.dao.StaffDao;
import com.julius.base.study.test.entity.Staff;
import com.julius.base.study.test.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Package: com.julius.base.common.test.service.impl
 * @ClassName: StaffServiceImpl
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/1/14 10:37
 * @Version: 1.0
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public Staff add(Staff staff) {
        return staffDao.add(staff);
    }

    @Override
    public Staff update(Staff staff) {
        return staffDao.update(staff);
    }

    @Override
    public String delete(String id) {
        return staffDao.delete(id);
    }

    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public List<Staff> findByPage(Integer currentPage, Integer pageSize) {
        return staffDao.findByPage(currentPage*pageSize,pageSize);
    }

    @Override
    public List<Staff> findAllByCondition(String name, Integer age, String departmentId) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"departmentId");
        Sort sort = Sort.by(order);
        return staffDao.findAllByCondition(name,age,departmentId, sort);
    }

    @Override
    public long countByCondition(String name, Integer age, String departmentId) {
        return staffDao.countByCondition(name,age,departmentId);
    }
}
