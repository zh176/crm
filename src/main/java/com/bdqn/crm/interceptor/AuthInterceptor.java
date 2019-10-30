package com.bdqn.crm.interceptor;

import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.utils.result.ResultEnum;
import com.bdqn.crm.utils.result.ResultView;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 忍
 * @title: AuthIntercpter
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1813:25
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        throw new MyRuntimeException(ResultView.error(ResultEnum.CODE_2));
//        return false;
//        System.out.println("拦截器执行了");
//        return true;
    }
}
