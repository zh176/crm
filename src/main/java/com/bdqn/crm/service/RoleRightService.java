package com.bdqn.crm.service;

import com.bdqn.crm.mapper.RoleRightMapper;
import com.bdqn.crm.model.RoleRight;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 忍
 * @title: RoleRight
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/179:14
 */
@Service
public class RoleRightService {
    @Autowired
    RoleRightMapper roleRightMapper;
    public List<com.bdqn.crm.model.RoleRight> getAll(){
        return roleRightMapper.getAll();
    }
    public PageInfo<RoleRight> getPageInfo (PagePrarm pagePrarm){
        int pageIndex = pagePrarm.getPageIndex();
        int pageSize = pagePrarm.getPageSize();
        PageHelper.startPage(pageIndex,pageSize);
        List<RoleRight> roleRights = roleRightMapper.getAll();
        PageInfo<RoleRight> pageInfo = new PageInfo<>(roleRights);
//        PageResult pageResult = new PageResult(pageIndex,pageSize,0,);
        return pageInfo;
    }
}
