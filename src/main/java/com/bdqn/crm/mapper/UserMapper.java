package com.bdqn.crm.mapper;

import com.bdqn.crm.model.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author 忍
 * @title: UserMapper
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1715:12
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名，密码查用户
     * @param userName 用户名
     * @param pwd 密码
     * @return
     */
    User getUser(String userName, String pwd);
    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return boolean
     */
    boolean updateUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUser(String name,String phone,Integer flag);

    /**
     * 根据id的获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    boolean delUserById(Long id);

    /**
     * 根据权限id获取用户
     * @param roleId
     * @return
     */
    List<User> getUserByRole(Integer roleId);

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    User getUserByName(String userName);
}
