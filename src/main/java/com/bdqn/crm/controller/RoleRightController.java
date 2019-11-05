package com.bdqn.crm.controller;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.crm.mapper.RoleRightMapper;
import com.bdqn.crm.model.RoleRight;
import com.bdqn.crm.service.RoleRightService;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.ResultView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 忍
 * @title: RoleRightController
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1623:40
 */
@RestController
@Api("菜单栏")
@RequestMapping("/roleRight")
public class RoleRightController {
    @Autowired
    RoleRightService roleRightService;

    @ApiOperation("根据权限id-菜单编号获取菜单")
    @GetMapping("/get")
    public ResultView getRoleRightByRole(Long roleId,String roleCode){
        String operate = roleRightService.getRoleRightByRole(roleId, roleCode);
        return ResultView.success(operate);
    }

    @ApiOperation("根据角色id 菜单编号循环插入")
    @PostMapping()
    public ResultView addRoleRights(String roleId,String rightId){
        System.out.println(555);
        boolean b = roleRightService.addRoleRights(Integer.valueOf(roleId), rightId);
        return ResultView.success(b);
    }

    @ApiOperation("根据角色id 菜单循环修改")
    @PutMapping("/{roleId}&{rightId}")
    public ResultView updRoleRight(@PathVariable Integer roleId,@PathVariable String rightId){
        System.out.println(rightId);
        boolean b = roleRightService.updRoleRight(roleId, rightId);
        return ResultView.success(b);
    }
}
