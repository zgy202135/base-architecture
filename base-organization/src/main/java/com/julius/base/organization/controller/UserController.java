package com.julius.base.organization.controller;

import com.julius.base.common.exception.ServiceException;
import com.julius.base.organization.dao.UserDao;
import com.julius.base.organization.dto.UserDTO;
import com.julius.base.organization.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.controller
 * @Author Julius Zhou
 * @Date 2020-07-26 10:56
 * @Description: 用户信息控制器
 * */
@Api(description = "user controller api",tags = "user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/user")
    @ApiOperation(value = "insert user info")
    public UserDTO insert(@RequestBody UserDTO userDTO)throws ServiceException{
        return userService.insert(userDTO);
    }

    @PutMapping(value = "/user")
    @ApiOperation(value = "update user info")
    public UserDTO update(@RequestBody UserDTO userDTO)throws ServiceException{
        return userService.insert(userDTO);
    }


    @GetMapping(value = "/user/{uuid}")
    @ApiOperation(value = "get user info by uuid")
    public UserDTO findByUuid(@PathVariable(value = "uuid") String uuid)throws ServiceException{
        return userService.findByUuid(uuid);
    }



}
