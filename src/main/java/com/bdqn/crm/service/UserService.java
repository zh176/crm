package com.bdqn.crm.service;

import com.bdqn.crm.mapper.UserMapper;
import com.bdqn.crm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 忍
 * @title: UserService
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1715:37
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getUser(String userName,String pwd){
        return userMapper.getUser(userName,pwd);
    }
}
