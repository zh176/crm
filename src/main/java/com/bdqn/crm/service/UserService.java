package com.bdqn.crm.service;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.RoleMapper;
import com.bdqn.crm.mapper.UserMapper;
import com.bdqn.crm.model.User;
import com.bdqn.crm.model.bo.PayloadBo;
import com.bdqn.crm.utils.CreateUtil;
import com.bdqn.crm.utils.JWTUtils;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultEnum;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
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

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    AuthTokenService authTokenService;

    public String getUser(String userName,String pwd){
        User user = userMapper.getUser(userName, pwd);
        if (user == null) {
            throw new MyRuntimeException(ResultView.error(ResultEnum.CODE_5));
        }
        if (!user.isFlag()){
            throw new MyRuntimeException(ResultView.error(ResultEnum.CODE_7));
        }
        String roleName = roleMapper.getRoleNameById(user.getRoleId());
        PayloadBo payloadBo = new PayloadBo(user.getId().toString(), userName, user.getRoleId(),roleName, user.getHeader());
        String token = JWTUtils.creatToken(payloadBo);
        authTokenService.addDataDic(user.getId().toString(), token);
        return token;
    }

    public User getUserByName(String userName){
        if (userName!=null){
            User user = userMapper.getUserByName(userName);
            return user;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public boolean addUser(User user){
        try{
            if (user!=null){
                user.setId(CreateUtil.id());
                user.setPassword("crm123456");
                user.setCreatTime(new Date());
                user.setFlag(true);
                userMapper.addUser(user);
                return true;
            }
            throw new RuntimeException("参数异常");
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(User user){
        try{
            if (user != null){
                userMapper.updateUser(user);
                return true;
            }
            throw new MyRuntimeException(ResultView.error("参数异常"));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public PageResult getAllUser(PagePrarm pagePrarm){
        Integer pageIndex = pagePrarm.getPageIndex();
        Integer pageSize = pagePrarm.getPageSize();

        JSONObject object = JSONObject.parseObject(pagePrarm.getCondition());
        PageHelper.startPage(pageIndex,pageSize);
        String name = null;
        String phone = null;
        Integer flag = null;
        if (object!=null){
            name = object.getString("name").trim();
            phone = object.getString("phone").trim();
            flag = object.getInteger("flag");
        }

        List<User> users = userMapper.getAllUser(name, phone, flag);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        PageResult pageResult = new PageResult(pageIndex, pageSize, Integer.parseInt(pageInfo.getTotal() + ""),
                pageInfo.getList());

        return pageResult;
    }

    public User getUserById (Long id){
        if (id!=null){
            return userMapper.getUserById(id);
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public boolean delUserById(Long id){
        try{
            if (id != null){
                userMapper.delUserById(id);
                return true;
            }
            throw new MyRuntimeException(ResultView.error("参数异常"));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public List<User> getUserByRole(Integer roleId){
        if (roleId!=null){
            List<User> users = userMapper.getUserByRole(roleId);
            return users;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public String getNameById(String  id){
        if (id!=null){
            String userName = userMapper.getNameById(id);
            return userName;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }
}
