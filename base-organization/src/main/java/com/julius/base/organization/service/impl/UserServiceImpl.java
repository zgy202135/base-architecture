package com.julius.base.organization.service.impl;

import com.baomidou.mybatisplus.core.toolkit.EncryptUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.julius.base.common.exception.ServiceException;
import com.julius.base.common.page.ResponsePage;
import com.julius.base.organization.common.constants.UserConstant;
import com.julius.base.organization.common.utils.CustomDataTransformUtil;
import com.julius.base.organization.common.utils.CustomUuidUtil;
import com.julius.base.organization.common.utils.DateFormatUtil;
import com.julius.base.organization.common.utils.EncryptUtil;
import com.julius.base.organization.dto.UserDTO;
import com.julius.base.organization.dto.UserRequestPageDTO;
import com.julius.base.organization.entity.User;
import com.julius.base.organization.exception.OrganizationError;
import com.julius.base.organization.mapper.UserMapper;
import com.julius.base.organization.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.service.impl
 * @Author Julius Zhou
 * @Date 2020-05-03 22:39
 * @Description: 用户基本信息服务层接口实现
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomUuidUtil uuidUtil;

    @Autowired
    private DateFormatUtil dateFormatUtil;

    @Autowired
    private CustomDataTransformUtil dataTransformUtil;



    /**
     * 新增用户信息
     *
     * @param userDTO
     * @return
     * @throws ServiceException
     */
    @Override
    public UserDTO insert(UserDTO userDTO) throws ServiceException {
        if(userDTO == null){
            throw new ServiceException(OrganizationError.USER_INFO_NOT_NULL.getCode(),OrganizationError.USER_INFO_NOT_NULL.getMessage());
        }
        userDTO.setUuid(uuidUtil.getUUID());
        userDTO.setCreateTime(dateFormatUtil.dateToLocalDate(LocalDate.now(), LocalTime.now(), UserConstant.DATE_TIME_FORMAT));
        userDTO.setUpdateTime(dateFormatUtil.dateToLocalDate(LocalDate.now(),LocalTime.now(),UserConstant.DATE_TIME_FORMAT));
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        user.setPassword(EncryptUtil.encrypt(user.getPassword()));
        //新增
        userMapper.insert(user);
        log.info("这里校验下是否获取到主键ID：{}",user.toString());
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
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
        if(userDTO == null || StringUtils.isEmpty(userDTO.getUuid())){
            throw new ServiceException(OrganizationError.USER_UUID_NOT_NULL.getCode(), OrganizationError.USER_UUID_NOT_NULL.getMessage());
        }
        //todo 查询
        User user = null;
        if(user == null || user.getId() == null){
            throw new ServiceException(OrganizationError.USER_INFO_IS_NOT_EXISTS.getCode(),OrganizationError.USER_INFO_IS_NOT_EXISTS.getMessage());
        }
        userDTO.setUpdateTime(dateFormatUtil.dateToLocalDate(LocalDate.now(),LocalTime.now(),UserConstant.DATE_TIME_FORMAT));
        BeanUtils.copyProperties(userDTO,user);
        //todo 更新
        return userDTO;
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
        if(StringUtils.isEmpty(uuid)){
            throw new ServiceException(OrganizationError.USER_UUID_NOT_NULL.getCode(),OrganizationError.USER_UUID_NOT_NULL.getMessage());
        }
        UserDTO userDTO = new UserDTO();
        User user = new User();
        user = userMapper.selectOne(Wrappers.lambdaQuery(user).eq(User::getUuid,uuid));
        if(user == null){
            return userDTO;
        }
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
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
        Sort sort = Sort.by(Sort.Direction.DESC,"updateTime");
        Pageable pageable = PageRequest.of(userRequestPageDTO.getCurrentPage(),userRequestPageDTO.getPageSize(),sort);
        Map<String,Object> paramMap = new HashMap<>(1<<4);
        if(!StringUtils.isEmpty(userRequestPageDTO.getName())){
            paramMap.put("name",userRequestPageDTO.getName());
        }
        if(userRequestPageDTO.getSex() != null){
            paramMap.put("sex",userRequestPageDTO.getSex());
        }
        ResponsePage<UserDTO> result = new ResponsePage<>(userRequestPageDTO.getCurrentPage(),userRequestPageDTO.getPageSize(),0,0L,null);
        //todo 分页查询
        Page<User> page = null;
        if(page == null){
            return result;
        }
        result = dataTransformUtil.poTransformDto(page,UserDTO.class,userRequestPageDTO.getCurrentPage(),userRequestPageDTO.getPageSize());
        return result;
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
        if (StringUtils.isEmpty(uuid)){
            throw new ServiceException(OrganizationError.USER_UUID_NOT_NULL.getCode(),OrganizationError.USER_UUID_NOT_NULL.getMessage());
        }
        //todo 查询
        User user = null;
        if(user == null || user.getId() == null){
            throw new ServiceException(OrganizationError.USER_INFO_IS_NOT_EXISTS.getCode(),OrganizationError.USER_INFO_IS_NOT_EXISTS.getMessage());
        }
        //todo 删除
        return uuid;
    }
}
