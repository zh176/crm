package com.bdqn.crm.config;

import com.bdqn.crm.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 忍
 * @title: InterceptorConfig
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1813:53
 */
@SpringBootConfiguration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/webjars/**","/swagger-resources/**",
                        "/swagger-resources/**","/v2/**","/swagger-ui.html",
                        "/user/login","/role/**","/right/**","/roleRight/**","/dic/**",
                        "/user/role/**","/user/name/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
