package com.julius.base.organization.service.impl;

import com.julius.base.common.exception.ServiceException;
import com.julius.base.common.page.RequestPage;
import com.julius.base.common.page.ResponsePage;
import com.julius.base.organization.common.constants.UserConstant;
import com.julius.base.organization.common.utils.CustomDataTransformUtil;
import com.julius.base.organization.common.utils.CustomUuidUtil;
import com.julius.base.organization.common.utils.DateFormatUtil;
import com.julius.base.organization.dao.DepartmentDao;
import com.julius.base.organization.dao.dynamic.DepartmentDynamicQuery;
import com.julius.base.organization.dto.DepartmentDTO;
import com.julius.base.organization.dto.DepartmentPageDTO;
import com.julius.base.organization.entity.Department;
import com.julius.base.organization.exception.OrganizationError;
import com.julius.base.organization.service.DepartmentService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.service.impl
 * @Author Julius Zhou
 * @Date 2020-08-02 16:41
 * @Description: 部门信息服务层接口实现
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private CustomUuidUtil customUuidUtil;

    @Autowired
    private DateFormatUtil dateFormatUtil;

    @Autowired
    private CustomDataTransformUtil customDataTransformUtil;

    @Autowired
    private DepartmentDynamicQuery departmentDynamicQuery;



    /**
     * 新增部门信息
     *
     * @param departmentDTO
     * @return
     * @throws ServiceException
     */
    @Override
    public DepartmentDTO insert(DepartmentDTO departmentDTO) throws ServiceException {
        log.info("insert a new department info start");
        if(departmentDTO == null){
            throw new ServiceException(OrganizationError.DEPARTMENT_INTO_NOT_NULL.getCode(),OrganizationError.DEPARTMENT_INTO_NOT_NULL.getMessage());
        }
        departmentDTO.setUuid(customUuidUtil.getUUID());
        departmentDTO.setCreateTime(dateFormatUtil.dateToLocalDate(LocalDate.now(), LocalTime.now(), UserConstant.DATE_TIME_FORMAT));
        departmentDTO.setUpdateTime(dateFormatUtil.dateToLocalDate(LocalDate.now(),LocalTime.now(),UserConstant.DATE_TIME_FORMAT));
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO,department);
        departmentDao.save(department);
        BeanUtils.copyProperties(department,departmentDTO);
        log.info("insert a new department info end");
        return departmentDTO;
    }

    /**
     * 更新部门信息
     *
     * @param departmentDTO
     * @return
     * @throws ServiceException
     */
    @Override
    public DepartmentDTO update(DepartmentDTO departmentDTO) throws ServiceException {
        log.info(" update a department info start");
        if(departmentDTO == null){
            throw new ServiceException(OrganizationError.DEPARTMENT_INTO_NOT_NULL.getCode(),OrganizationError.DEPARTMENT_INTO_NOT_NULL.getMessage());
        }
        if(StringUtils.isEmpty(departmentDTO.getUuid())){
            throw new ServiceException(OrganizationError.DEPARTMENT_UUID_NOT_NULL.getCode(),OrganizationError.DEPARTMENT_UUID_NOT_NULL.getMessage());
        }
        Department department = departmentDao.findByUuid(departmentDTO.getUuid());
        if(department == null || department.getId() == null){
            throw new ServiceException(OrganizationError.DEPARTMENT_INFO_IS_NOT_EXISTS.getCode(),OrganizationError.DEPARTMENT_INFO_IS_NOT_EXISTS.getMessage());
        }
        departmentDTO.setUpdateTime(dateFormatUtil.dateToLocalDate(LocalDate.now(),LocalTime.now(),UserConstant.DATE_TIME_FORMAT));
        Integer id = department.getId();
        BeanUtils.copyProperties(departmentDTO,department);
        department.setId(id);
        departmentDao.save(department);
        log.info(" update a department info end");
        return departmentDTO;
    }

    /**
     * 根据uuid查询
     *
     * @param uuid
     * @return
     * @throws ServiceException
     */
    @Override
    public DepartmentDTO findByUuid(String uuid) throws ServiceException {
        log.info(" find a department info by uuid start");
        if(StringUtils.isEmpty(uuid)){
            throw new ServiceException(OrganizationError.DEPARTMENT_UUID_NOT_NULL.getCode(),OrganizationError.DEPARTMENT_UUID_NOT_NULL.getMessage());
        }
        Department department = departmentDao.findByUuid(uuid);
        if(department == null){
            return null;
        }
        DepartmentDTO departmentDTO = new DepartmentDTO();
        BeanUtils.copyProperties(department,departmentDTO);
        log.info("find a department info by uuid end");
        return departmentDTO;
    }

    /**
     * 根据父uuid查询所有
     *
     * @param uuid
     * @return
     * @throws ServiceException
     */
    @Override
    public List<DepartmentDTO> findAllByParentUuid(String uuid) throws ServiceException {
        log.info("find all department info by parent uuid start");
        if(StringUtils.isEmpty(uuid)){
            throw new ServiceException(OrganizationError.DEPARTMENT_UUID_NOT_NULL.getCode(),OrganizationError.DEPARTMENT_UUID_NOT_NULL.getMessage());
        }
        List<Department> departmentList = departmentDao.findAllByParentUuid(uuid);
        if(departmentList == null || departmentList.size() == 0){
            return new ArrayList<>();
        }
        List<DepartmentDTO> result = customDataTransformUtil.poTransformDTOList(departmentList,DepartmentDTO.class);
        log.info("find all department info by parent uuid end");
        return result;
    }

    /**
     * 根据uuid删除
     *
     * @param uuid
     * @return
     * @throws ServiceException
     */
    @Override
    public String deleteByUuid(String uuid) throws ServiceException {
        log.info("delete department info by uuid start");
        if(StringUtils.isEmpty(uuid)){
            throw new ServiceException(OrganizationError.DEPARTMENT_UUID_NOT_NULL.getCode(),OrganizationError.DEPARTMENT_UUID_NOT_NULL.getMessage());
        }
        Department department = departmentDao.findByUuid(uuid);
        if(department == null){
            throw new ServiceException(OrganizationError.DEPARTMENT_INFO_IS_NOT_EXISTS.getCode(),OrganizationError.DEPARTMENT_INFO_IS_NOT_EXISTS.getMessage());
        }
        departmentDao.delete(department);
        log.info("delete department info by uuid end");
        return uuid;
    }

    /**
     * 复杂分页查询
     * @param departmentPageDTO
     * @return
     * @throws ServiceException
     */
    @Override
    public ResponsePage<DepartmentDTO> findOfPage(DepartmentPageDTO departmentPageDTO) throws ServiceException {
        if(departmentPageDTO == null){
            throw new ServiceException(OrganizationError.PAGE_PARAMETER_NOT_NULL.getCode(),OrganizationError.PAGE_PARAMETER_NOT_NULL.getMessage());
        }
        Sort sort = Sort.by(Sort.Direction.DESC,"updateTime");
        Pageable pageable = PageRequest.of(departmentPageDTO.getCurrentPage(),departmentPageDTO.getPageSize(),sort);
        Map<String,Object> paramMap = new HashMap<>(1<<4);
        if(!StringUtils.isEmpty(departmentPageDTO.getName())){
            paramMap.put("name",departmentPageDTO.getName());
        }
        Page<Department> page = departmentDao.findAll(departmentDynamicQuery.where(paramMap),pageable);
        return customDataTransformUtil.poTransformDto(page,DepartmentDTO.class,departmentPageDTO.getCurrentPage(),departmentPageDTO.getPageSize());
    }
}
