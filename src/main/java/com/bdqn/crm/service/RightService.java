package com.bdqn.crm.service;

import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.RightMapper;
import com.bdqn.crm.model.Right;
import com.bdqn.crm.model.Role;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author 忍
 * @title: RightService
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1810:05
 */
@Service
//@CacheConfig(cacheNames = "rightCache")
public class RightService  {
    @Autowired
    RightMapper rightMapper;
//    @Cacheable(key = "#p0",unless = "#result == null")
    public List<Right> getRightByRole(long roleId){
        if (StringUtils.isEmpty(roleId)){
            throw new MyRuntimeException(ResultView.error("参数错误"));
        }
        List<Right> role = rightMapper.getRightByRole(roleId);
        return role;
    }

    public PageInfo<Right> getAllRight(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Right> rights = rightMapper.getAllRight();
        System.out.println(rights.get(0));
        PageInfo<Right> pageInfo = new PageInfo<>(rights);
        return pageInfo;
    }
}
