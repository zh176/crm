package com.bdqn.crm.controller;

import com.bdqn.crm.model.Server;
import com.bdqn.crm.service.ServerService;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/all")
    public ResultView getAllServer(PagePrarm pagePrarm){
        PageResult servers = serverService.getAllServer(pagePrarm);
        return ResultView.success(servers);
    }

    @ApiOperation("分配服务")
    @PostMapping("/allot")
    public ResultView allotServer(Server server){
        boolean b = serverService.allotServer(server);
        return ResultView.success(b);
    }

    @ApiOperation("服务处理")
    @PostMapping("/dispose")
    public ResultView disposeServer(Server server){
        boolean b = serverService.disposeServer(server);
        return ResultView.success(b);
    }
    @ApiOperation("服务反馈")
    @PostMapping("/feedback")
    public ResultView feedbackServer(Server server){
        boolean b = serverService.feedbackServer(server);
        return ResultView.success(b);
    }

    @DeleteMapping("/{serverId}")
    public ResultView delServer(@PathVariable Integer serverId){
        boolean b = serverService.delServer(serverId);
        return ResultView.success(b);
    }

    @GetMapping("/{serverId}")
    public ResultView getServerById(@PathVariable Integer serverId){
        Server server = serverService.getServerById(serverId);
        return ResultView.success(server);
    }
}
