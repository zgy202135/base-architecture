package com.julius.base.organization.service;

import com.julius.base.common.exception.ServiceException;
import com.julius.base.common.page.ResponsePage;
import com.julius.base.organization.dto.UserDTO;
import com.julius.base.organization.dto.UserRequestPageDTO;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.service
 * @Author Julius Zhou
 * @Date 2020-05-03 22:38
 * @Description: 用户基本信息服务层接口实现
 */
public interface UserService {


    /**
     * 新增用户信息
     * @param userDTO
     * @return
     * @throws ServiceException
     */
    UserDTO insert(UserDTO userDTO)throws ServiceException;


    /**
     * 更新用户信息
     * @param userDTO
     * @return
     * @throws ServiceException
     */
    UserDTO update(UserDTO userDTO) throws ServiceException;

    /**
     * 根据uuid查询用户信息
     * @param uuid
     * @return
     * @throws ServiceException
     */
    UserDTO findByUuid(String uuid)throws ServiceException;

    /**
     * 按照分页查询
     * @param userRequestPageDTO
     * @return
     * @throws ServiceException
     */
    ResponsePage<UserDTO> findOfPage(UserRequestPageDTO userRequestPageDTO)throws ServiceException;


    /**
     * 根据uuid删除用户信息
     * @param uuid
     * @return
     * @throws ServiceException
     */
    String deleteByUuid(String uuid)throws ServiceException;

}
