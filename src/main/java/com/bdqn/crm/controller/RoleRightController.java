package com.bdqn.crm.controller;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.crm.mapper.RoleRightMapper;
import com.bdqn.crm.model.RoleRight;
import com.bdqn.crm.service.RoleRightService;
import com.bdqn.crm.utils.result.PagePrarm;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 忍
 * @title: RoleRightController
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1623:40
 */
@RestController
@Api
public class RoleRightController {
    @Autowired
    RoleRightService roleRightService;
    @GetMapping("/all")
    public String getAll(){
        return JSONObject.toJSONString(roleRightService.getAll());
    }
    @PostMapping("/page")
    public Object getPage(@RequestBody PagePrarm pagePrarm){
        return roleRightService.getPageInfo(pagePrarm);
    }
}
