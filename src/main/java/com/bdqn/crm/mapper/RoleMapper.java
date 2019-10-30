package com.bdqn.crm.mapper;

import com.bdqn.crm.model.Role;
import org.springframework.stereotype.Repository;

/**
 * @author 忍
 * @title: RoleMapper
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/2511:24
 */
@Repository
public interface RoleMapper {
    /**
     * 根据角色id获取角色名
     * @param id
     * @return
     */
    String getRoleById(int id);
}
