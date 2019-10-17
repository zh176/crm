package com.bdqn.crm.mapper;

import com.bdqn.crm.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author 忍
 * @title: UserMapper
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1715:12
 */
@Repository
public interface UserMapper {

    User getUser(String userName, String pwd);
}
