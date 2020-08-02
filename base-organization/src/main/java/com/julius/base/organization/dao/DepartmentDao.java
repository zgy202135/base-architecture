package com.julius.base.organization.dao;

import com.julius.base.common.exception.ServiceException;
import com.julius.base.organization.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.dao
 * @Author Julius Zhou
 * @Date 2020-08-02 16:44
 * @Description: 部门信息持久层接口
 */
@Repository
public interface DepartmentDao extends JpaRepository<Department,Integer> , JpaSpecificationExecutor<Department> {


    /**
     * 根据uuid查询
     * @param uuid
     * @return
     * @throws ServiceException
     */
    Department findByUuid(String uuid)throws ServiceException;


    /**
     * 根据父uuid查询所有
     * @param parentUuid
     * @return
     * @throws ServiceException
     */
    List<Department> findAllByParentUuid(String parentUuid)throws ServiceException;
}
