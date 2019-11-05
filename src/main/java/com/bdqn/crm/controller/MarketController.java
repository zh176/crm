package com.bdqn.crm.controller;

import com.bdqn.crm.model.Market;
import com.bdqn.crm.service.MarketService;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("销售机会管理")
@RestController
@RequestMapping("/marker")
public class MarketController {
    @Autowired
    MarketService marketService;

    @ApiOperation(value = "根据Id获取信息")
    @GetMapping("/list")
    public ResultView MarketById(Integer id){
        Market market = marketService.MarketById(id);
        return ResultView.success(market);
    }

    @ApiOperation(value = "销售机会信息")
    @GetMapping("/all")
    public ResultView all(PagePrarm pagePrarm){
        //查询所有角色
        PageResult market = marketService.getAllMarket(pagePrarm);
        return ResultView.success(market);
    }

    @ApiOperation(value="删除信息")
    @DeleteMapping("/delet")
    public ResultView deletMarket(Integer id){
        marketService.deletMarket(id);
        return ResultView.success();
    }

    @ApiOperation(value = "添加信息")
    @PostMapping("/add")
    public ResultView addMarket(Market market){
        marketService.addMarket(market);
        return ResultView.success();
    }

    @ApiOperation(value = "修改信息")
    @PostMapping("/update")
    public ResultView updateMarket(Market market){
        marketService.updateMarket(market);
        return ResultView.success();
    }
}
