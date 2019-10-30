package com.bdqn.crm.controller;

import com.bdqn.crm.model.Right;
import com.bdqn.crm.model.Role;
import com.bdqn.crm.service.RightService;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 忍
 * @title: RIghtController
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1810:13
 */
@RestController
@RequestMapping("/right")
public class RightController {
    @Autowired
    RightService rightService;
    @GetMapping("/{roleId}")
    public ResultView getRightById(@PathVariable Integer roleId){
        List<Right> rights = rightService.getRightByRole(roleId);
        return ResultView.success(rights);
    }
    @GetMapping("/all")
    public ResultView getAllRight(Integer pageNum,Integer pageSize){
        PageInfo<Right> rights = rightService.getAllRight(pageNum, pageSize);
        return ResultView.success(rights);
    }
}
