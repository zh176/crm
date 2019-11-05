package com.bdqn.crm.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.RoleMapper;
import com.bdqn.crm.model.Role;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 忍
 * @title: RoleService
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/2513:10
 */
@CacheConfig(cacheNames = "role")
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Cacheable(key = "#p0")
    public String getRoleById(int id){
        String roleName = roleMapper.getRoleNameById(id);
        if (roleName == null){
            throw new MyRuntimeException(ResultView.error("没有数据"));
        }
        return roleName;
    }
    public PageResult getAllRole(PagePrarm pagePrarm){
        int pageIndex = pagePrarm.getPageIndex();
        int pageSize = pagePrarm.getPageSize();
        PageHelper.startPage(pageIndex,pageSize);
        JSONObject jsonObject = JSON.parseObject(pagePrarm.getCondition());
        String name = null;
        if (jsonObject!=null){
            name = jsonObject.getString("name").trim();
        }
        System.out.println(name);
        List<Role> roles = roleMapper.getAllRole(name);
        PageInfo<Role> rolePageInfo = new PageInfo<>(roles);
        Integer total = Integer.valueOf(rolePageInfo.getTotal()+"");
        PageResult pageResult = new PageResult(pageIndex, pageSize, total, rolePageInfo.getList());
        return pageResult;
    }

    public Integer addRole(Role role){
        if (role!=null){
            roleMapper.addRole(role);
            return role.getId();
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public Role getRoleById(Integer roleId){
        if (roleId!=null){
            Role role = roleMapper.getRoleById(roleId);
            return role;
        }
        throw  new MyRuntimeException(ResultView.error("参数异常"));
    }
    public boolean updRole(Role role){
        if (role!=null){
            roleMapper.updateRole(role);
            return true;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public boolean delRole(Integer roleId){
        if (roleId!=null){
            roleMapper.delRole(roleId);
            return true;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));

    }
}
