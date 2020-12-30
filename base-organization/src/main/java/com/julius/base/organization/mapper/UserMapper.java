package com.julius.base.organization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.julius.base.organization.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.mapper
 * @Author Julius Zhou
 * @Date 2020-12-27 17:15
 * @Description: 用户基本信息持久层接口
 */
@Repository
public interface UserMapper extends BaseMapper<User> {



}
