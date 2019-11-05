package com.bdqn.crm.controller;

import com.bdqn.crm.model.Server;
import com.bdqn.crm.service.ServerService;
import com.bdqn.crm.utils.result.ResultView;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 忍
 * @title: ServerController
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/511:18
 */
@RestController
@RequestMapping("/server")
@Api("服务管理控制器")
public class ServerController {
    @Autowired
    ServerService serverService;


    @PostMapping("/add")
    public ResultView creatServer(Server server){
        boolean res = serverService.createServer(server);
        return ResultView.success(res);
    }
}
