package com.bdqn.crm.service;

import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.RoleMapper;
import com.bdqn.crm.utils.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
        String roleName = roleMapper.getRoleById(id);
        if (roleName == null){
            throw new MyRuntimeException(ResultView.error("没有数据"));
        }
        return roleName;
    }
}
