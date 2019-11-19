package com.bdqn.crm.controller;

import com.bdqn.crm.model.User;
import com.bdqn.crm.service.UserService;
import com.bdqn.crm.utils.CreateUtil;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

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
    public ResultView getUser(String username, String password){
        String token = userService.getUser(username, password);
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
    public ResultView updateUser(@RequestBody User user){
        System.out.println(user);
        boolean result = userService.updateUser(user);
        return ResultView.success(result);
    }
    @ApiOperation("查询所有用户")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "condition",value ="{\"phone\":\"12345678911\",\"name\":\"admin\",\"flag\":\"1\"}" )
            }
    )
    @GetMapping("/all")
    public ResultView getAllUser(PagePrarm pagePrarm){
        PageResult p = userService.getAllUser(pagePrarm);
        return ResultView.success(p);
    }

    @GetMapping("/{id}")
    public ResultView getUSerById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResultView.success(user);
    }

    @ApiOperation("根据id删除元素")
    @DeleteMapping("/del/{id}")
    public ResultView delUser(@PathVariable Long id){
        boolean result = userService.delUserById(id);
        return ResultView.success(result);
    }
    @ApiOperation("根据权限id获取用户")
    @GetMapping("/role/{roleId}")
    public ResultView getUserByRole(@PathVariable Integer roleId){
        List<User> users = userService.getUserByRole(roleId);
        return ResultView.success(users);
    }
}
