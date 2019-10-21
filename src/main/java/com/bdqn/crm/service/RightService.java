package com.bdqn.crm.service;

import com.bdqn.crm.mapper.RightMapper;
import com.bdqn.crm.model.Right;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 忍
 * @title: RightService
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1810:05
 */
public class RightService  {
    @Autowired
    RightMapper rightMapper;
    public void getRightByRole(long roleId){
        rightMapper.getRightByRole(roleId);
    }
}
