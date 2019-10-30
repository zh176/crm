package com.bdqn.crm.controller;

import com.bdqn.crm.model.User;
import com.bdqn.crm.service.UserService;
import com.bdqn.crm.utils.CreateUtil;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

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
    @PostMapping("/add")
    public ResultView addUser(User user){
        long s = System.currentTimeMillis();
        boolean flag = userService.addUser(user);
        long e = System.currentTimeMillis();
        System.out.println(e-s);

        return ResultView.success(flag);
    }
    @ApiOperation("修改用户")
    @PutMapping("/upd")
    public ResultView updateUser(User user){
        long s = System.currentTimeMillis();
        boolean result = userService.updateUser(user);
        long e = System.currentTimeMillis();
        System.out.println(e-s);
        return ResultView.success(result);
    }
    @ApiOperation("查询所有用户")
    @GetMapping("/all")
    public ResultView getAllUser(PagePrarm pagePrarm){
        PageResult p = userService.getAllUser(pagePrarm);
        return ResultView.success(p);
    }
}
