package com.bdqn.crm.service;

import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.AuthTokenMapper;
import com.bdqn.crm.utils.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 忍
 * @title: AuthTokenService
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/1111:35
 */
@Service
public class AuthTokenService {
    @Autowired
    AuthTokenMapper authTokenMapper;

    public boolean addDataDic(String userId,String token){
        boolean flag = false;
        if (userId!=null){
            String token1 = authTokenMapper.getTokenByUserId(userId);
            if (token1 == null){
                boolean b = authTokenMapper.addAuthToken(userId, token);
                flag = b;
            }else {
                boolean b = authTokenMapper.updAuthToken(userId, token);
                flag = b;
            }
            return flag;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public boolean verifyToken(String userId,String token){
        String token1 = authTokenMapper.getTokenByUserId(userId);
        if (token1==null){
            return false;
        }
        if (token1.equals(token)){
            return true;
        }
        return false;
    }
}
