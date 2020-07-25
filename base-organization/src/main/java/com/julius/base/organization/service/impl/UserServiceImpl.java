package com.julius.base.organization.service.impl;

import com.julius.base.common.exception.ServiceException;
import com.julius.base.common.page.ResponsePage;
import com.julius.base.organization.common.dao.UserDao;
import com.julius.base.organization.common.utils.CustomUuidUtil;
import com.julius.base.organization.common.utils.DateFormatUtil;
import com.julius.base.organization.dto.UserDTO;
import com.julius.base.organization.dto.UserRequestPageDTO;
import com.julius.base.organization.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.service.impl
 * @Author Julius Zhou
 * @Date 2020-05-03 22:39
 * @Description: 用户基本信息服务层接口实现
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private CustomUuidUtil uuidUtil;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DateFormatUtil dateFormatUtil;



    /**
     * 新增用户信息
     *
     * @param userDTO
     * @return
     * @throws ServiceException
     */
    @Override
    public UserDTO insert(UserDTO userDTO) throws ServiceException {
        return null;
    }

    /**
     * 更新用户信息
     *
     * @param userDTO
     * @return
     * @throws ServiceException
     */
    @Override
    public UserDTO update(UserDTO userDTO) throws ServiceException {
        return null;
    }

    /**
     * 根据uuid查询用户信息
     *
     * @param uuid
     * @return
     * @throws ServiceException
     */
    @Override
    public UserDTO findByUuid(String uuid) throws ServiceException {
        return null;
    }

    /**
     * 按照分页查询
     *
     * @param userRequestPageDTO
     * @return
     * @throws ServiceException
     */
    @Override
    public ResponsePage<UserDTO> findOfPage(UserRequestPageDTO userRequestPageDTO) throws ServiceException {
        return null;
    }

    /**
     * 根据uuid删除用户信息
     *
     * @param uuid
     * @return
     * @throws ServiceException
     */
    @Override
    public String deleteByUuid(String uuid) throws ServiceException {
        return null;
    }
}
