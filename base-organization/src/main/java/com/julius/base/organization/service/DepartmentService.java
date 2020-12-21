package com.julius.base.organization.service;

import com.julius.base.common.exception.ServiceException;
import com.julius.base.common.page.ResponsePage;
import com.julius.base.organization.dto.DepartmentDTO;
import com.julius.base.organization.dto.DepartmentPageDTO;

import java.util.List;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.service
 * @Author Julius Zhou
 * @Date 2020-08-02 16:26
 * @Description: 部门信息服务层接口
 */
public interface DepartmentService {

    /**
     * 新增部门信息
     * @param departmentDTO
     * @return
     * @throws ServiceException
     */
    DepartmentDTO insert(DepartmentDTO departmentDTO)throws ServiceException;


    /**
     * 更新部门信息
     * @param departmentDTO
     * @return
     * @throws ServiceException
     */
    DepartmentDTO update(DepartmentDTO departmentDTO)throws ServiceException;

    /**
     * 根据uuid查询
     * @param uuid
     * @return
     * @throws ServiceException
     */
    DepartmentDTO findByUuid(String uuid)throws ServiceException;


    /**
     * 根据父uuid查询所有
     * @param uuid
     * @return
     * @throws ServiceException
     */
    List<DepartmentDTO> findAllByParentUuid(String uuid)throws ServiceException;

    /**
     * 根据uuid删除
     * @param uuid
     * @return
     * @throws ServiceException
     */
    String deleteByUuid(String uuid)throws ServiceException;

    /**
     * 复杂分页查询
     * @param departmentPageDTO
     * @return
     * @throws ServiceException
     */
    ResponsePage<DepartmentDTO> findOfPage(DepartmentPageDTO departmentPageDTO)throws ServiceException;
}
