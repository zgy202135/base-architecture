package com.julius.base.organization.controller;

import com.julius.base.common.exception.ServiceException;
import com.julius.base.organization.dto.DepartmentDTO;
import com.julius.base.organization.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.controller
 * @Author Julius Zhou
 * @Date 2020-08-02 16:46
 * @Description: 部门信息控制器
 */
@RestController
@Api(description = "部门信息API",tags = "部门信息")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 新增部门信息
     * @param departmentDTO
     * @return
     * @throws ServiceException
     */
    @PostMapping("/department")
    @ApiOperation(value = "新增部门信息")
    @ResponseStatus(value = HttpStatus.CREATED)
    DepartmentDTO insert(@RequestBody DepartmentDTO departmentDTO)throws ServiceException{
        return departmentService.insert(departmentDTO);
    }


    /**
     * 更新部门信息
     * @param departmentDTO
     * @return
     * @throws ServiceException
     */
    @PutMapping("/department")
    @ApiOperation(value = "更新部门信息")
    DepartmentDTO update(@RequestBody DepartmentDTO departmentDTO)throws ServiceException{
        return departmentService.update(departmentDTO);
    }

    /**
     * 根据uuid查询
     * @param uuid
     * @return
     * @throws ServiceException
     */
    @GetMapping("/department/{uuid}")
    @ApiOperation(value = "按照uuid查询")
    DepartmentDTO findByUuid(@PathVariable String uuid)throws ServiceException{
        return departmentService.findByUuid(uuid);
    }


    /**
     * 根据父uuid查询所有
     * @param uuid
     * @return
     * @throws ServiceException
     */
    @GetMapping("/department/parent/{uuid}")
    @ApiOperation(value = "按照父uuid查询")
    List<DepartmentDTO> findAllByParentUuid(@PathVariable String uuid)throws ServiceException{
        return departmentService.findAllByParentUuid(uuid);
    }

    /**
     * 根据uuid删除
     * @param uuid
     * @return
     * @throws ServiceException
     */
    @DeleteMapping("/department/{uuid}")
    @ApiOperation(value = "按照uuid删除")
    @ResponseStatus
    String deleteByUuid(@PathVariable String uuid)throws ServiceException{
        return departmentService.deleteByUuid(uuid);
    }

}
