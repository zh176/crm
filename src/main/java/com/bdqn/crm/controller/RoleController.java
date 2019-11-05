package com.bdqn.crm.controller;

import com.bdqn.crm.model.Role;
import com.bdqn.crm.service.RoleService;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.page.PageParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 忍
 * @title: RoleController
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/110:16
 */
@Api("权限管理")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @ApiOperation("获取所有的权限")
    @GetMapping("/all")
    public ResultView getAllRole(PagePrarm pageParam){
        PageResult roles = roleService.getAllRole(pageParam);
        return ResultView.success(roles);
    }
    @PostMapping()
    @ApiOperation("添加角色")
    public ResultView addRole(Role role){
        Integer roleId = roleService.addRole(role);
        return ResultView.success(roleId);
    }
    @GetMapping("/{roleId}")
    public ResultView getRoleById(@PathVariable Integer roleId){
        Role role = roleService.getRoleById(roleId);
        return ResultView.success(role);
    }
    @PutMapping()
    public ResultView updRole(@RequestBody Role role){
        System.out.println(role);
        boolean b = roleService.updRole(role);
        return ResultView.success(b);
    }
    @ApiOperation("/根据id删除元素")
    @DeleteMapping("/{roleId}")
    public ResultView delRole(@PathVariable Integer roleId){
        boolean b = roleService.delRole(roleId);
        return ResultView.success(b);
    }
}
