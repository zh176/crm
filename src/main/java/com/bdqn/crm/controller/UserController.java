package com.bdqn.crm.controller;

import com.bdqn.crm.model.User;
import com.bdqn.crm.service.UserService;
import com.bdqn.crm.utils.CreateUtil;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 忍
 * @title: UserController
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1615:37
 */
@Api("用户控制器")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "用户登录",notes = "根据用户名-密码登录")
    @PostMapping("/login")
    public ResultView getUser(String userName, String pwd){
        String token = userService.getUser(userName, pwd);
        return ResultView.success(token);
    }

    @ApiOperation("添加用户")
    @PutMapping("/add")
    public ResultView addUser(User user){
        return null;
    }
}
