package com.bdqn.crm.mapper;

import org.springframework.stereotype.Repository;

/**
 * @author 忍
 * @title: AuthTokenMapper
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/1111:07
 */
@Repository
public interface AuthTokenMapper {

    /**
     * 根据用户id获取token
     * @param userId
     * @return
     */
    String getTokenByUserId(String userId);

    /**
     * 添加token信息
     * @param userId
     * @param token
     * @return
     */
    boolean addAuthToken(String userId,String token);

    /**
     * 修改token信息
     * @param userId
     * @param token
     * @return
     */
    boolean updAuthToken(String userId,String token);
}
