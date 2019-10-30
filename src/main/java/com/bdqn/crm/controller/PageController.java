package com.bdqn.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 忍
 * @title: PageController
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/2310:37
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/login")
    public String getLogin(){
        return "login";
    }
}
