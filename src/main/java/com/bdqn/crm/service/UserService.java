package com.bdqn.crm.service;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.UserMapper;
import com.bdqn.crm.model.User;
import com.bdqn.crm.model.bo.PayloadBo;
import com.bdqn.crm.utils.JWTUtils;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultEnum;
import com.bdqn.crm.utils.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author 忍
 * @title: UserService
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1715:37
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public String getUser(String userName,String pwd){
        User user = userMapper.getUser(userName, pwd);
        if (user == null) {
            throw new MyRuntimeException(ResultView.error(ResultEnum.CODE_5));
        }
        if (!user.isFlag()){
            throw new MyRuntimeException(ResultView.error(ResultEnum.CODE_7));
        }
        PayloadBo payloadBo = new PayloadBo(user.getId(), userName, user.getRoleId(), user.getHeader());
        String token = JWTUtils.creatToken(payloadBo);
        return token;
    }

}
