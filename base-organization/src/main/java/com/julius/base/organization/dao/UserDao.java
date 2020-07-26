package com.julius.base.organization.dao;

import com.julius.base.common.exception.ServiceException;
import com.julius.base.organization.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.dao
 * @Author Julius Zhou
 * @Date 2020-07-25 20:25
 * @Description: 用户信息持久层接口
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {

    /**
     * 根据uuid查询
     * @param uuid
     * @return
     * @throws ServiceException
     */
    User findByUuid(String uuid)throws ServiceException;

}
