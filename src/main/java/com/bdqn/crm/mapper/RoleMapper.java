package com.bdqn.crm.mapper;

import com.bdqn.crm.model.Role;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

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
    String getRoleNameById(int id);

    /**
     * 获取所有的权限
     * @param name 权限名
     * @return
     */
    List<Role> getAllRole(String name);

    /**
     * 添加角色
     * @param role 角色对象
     * @return 角色id
     */
    Integer addRole(Role role);

    /**
     * 根据角色id获取角色对象
     * @param roleId
     * @return
     */
    Role getRoleById(Integer roleId);

    /**
     * 修改角色
     * @param role
     * @return
     */
    boolean updateRole(Role role);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    boolean delRole(Integer roleId);

}
