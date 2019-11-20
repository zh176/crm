package com.bdqn.crm.interceptor;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.model.Right;
import com.bdqn.crm.model.RoleRight;
import com.bdqn.crm.model.bo.PayloadBo;
import com.bdqn.crm.service.AuthTokenService;
import com.bdqn.crm.service.RightService;
import com.bdqn.crm.service.RoleRightService;
import com.bdqn.crm.utils.JWTUtils;
import com.bdqn.crm.utils.result.ResultEnum;
import com.bdqn.crm.utils.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 忍
 * @title: AuthIntercpter
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1813:25
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {


    @Autowired
    AuthTokenService authTokenService;

    @Autowired
    RoleRightService roleRightService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            String token = request.getHeader("Authorization");
            System.out.println("================="+token);
            System.out.println("+++++++++++++++++"+request.getRequestURI());
            System.out.println("METHOD:" + request.getMethod());
            if (token!=null){
                PayloadBo payloadBo = JWTUtils.getPlayLoad(token);
                //获取uri
                String uri = request.getRequestURI();
                //获取请求方法
                String methodType = request.getMethod();
                boolean flag = authTokenService.verifyToken(payloadBo.getUserId().toString(),token);
                System.out.println(flag);
                if (flag){
                    boolean flag1 = uriAdapter(uri, payloadBo.getRoleId().toString(), request.getMethod());
                    return flag1;
                }
            }
            throw new MyRuntimeException(ResultView.error(ResultEnum.CODE_401));
        }catch (TokenExpiredException e){
            throw new MyRuntimeException(ResultView.error(ResultEnum.CODE_401));
        }


    }


    public boolean uriAdapter(String uri,String roleId,String methodType){
        System.out.println("Method-----:"+methodType);
        List<RoleRight> roleRights = roleRightService.getUrlByRoleId(Integer.valueOf(roleId));

        String method = methodTypeToString(methodType);
        //拆解uri
        String url = "/"+uri.split("/")[1];
        System.out.println("URI-----:"+uri);
        if (url.equals("/server")){
            return true;
        }
        for (RoleRight roleRight: roleRights) {
            System.out.println(roleRight.getOperate()+":"+roleRight.getRightCode());
            if (url.equals(roleRight.getRightCode()) && roleRight.getOperate().contains(method)){
                return true;
            }
        }
            throw new MyRuntimeException(ResultView.error(ResultEnum.CODE_12));
    }

    public String methodTypeToString(String MethodType){
        if (MethodType.equals("POST")){
            return "add";
        }
        if (MethodType.equals("PUT")){
            return "upd";
        }
        if (MethodType.equals("DELETE")){
            return "del";
        }
        if (MethodType.equals("GET")){
            return "view";
        }
        return null;
    }

    public static void main(String[] args) {
        String test = "add,view,del,upd";
        System.out.println(test.indexOf("upd"));
    }
}
