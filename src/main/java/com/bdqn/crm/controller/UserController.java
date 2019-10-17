package com.bdqn.crm.controller;

import com.bdqn.crm.model.User;
import com.bdqn.crm.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 忍
 * @title: UserController
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1615:37
 */
@Api
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public User getUser(String userName,String pwd){
        return userService.getUser(userName,pwd);
    }
}
