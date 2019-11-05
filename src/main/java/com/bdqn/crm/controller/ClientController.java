package com.bdqn.crm.controller;

import com.bdqn.crm.model.Client;
import com.bdqn.crm.service.ClientService;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("客户信息")
@RequestMapping("/client")
@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @ApiOperation(value = "客户信息")
    @GetMapping("/inquire")
    public ResultView findClient(String name,String no,String region,long managerId,String levelLabel){
        List<Client> miss=clientService.findClient(name,no,region,managerId,levelLabel);
        return ResultView.success(miss);
    }

    @ApiOperation(value = "修改客户信息")
    @PutMapping("/update")
    public ResultView updateClient(Client client){
        boolean result = clientService.updateClient(client);
        return ResultView.success(result);
    }

    @ApiOperation(value = "删除客户信息")
    @DeleteMapping("/del")
    public ResultView deleteClient(String no,String name){
        boolean flag= clientService.deleteClient(no,name);
        return ResultView.success(flag);
    }
    @ApiOperation(value = "添加客户信息")
    @PostMapping("/add")
    public ResultView addClient(Client client){
        boolean flag= clientService.addClient(client);
        return ResultView.success(flag);
    }

    @ApiOperation("查询客户信息")
    @GetMapping("/all")
    public ResultView getAllClient(PagePrarm pagePrarm){
        PageResult pageResult=clientService.getAllClient(pagePrarm);
        return ResultView.success(pageResult);
    }
}
