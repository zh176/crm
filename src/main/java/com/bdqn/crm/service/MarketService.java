package com.bdqn.crm.service;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.crm.mapper.MarketMapper;
import com.bdqn.crm.model.Market;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarketService {
    @Autowired
    MarketMapper marketMapper;

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    public Market MarketById(Integer id){
        Market market = marketMapper.MarketById(id);
        return market;
    }

    /**
     * 查询
     * @return
     */
    public PageResult getAllMarket(PagePrarm pagePrarm){
        Integer pageIndex = pagePrarm.getPageIndex();
        Integer pageSize = pagePrarm.getPageSize();

        JSONObject object = JSONObject.parseObject(pagePrarm.getCondition());
        PageHelper.startPage(pageIndex,pageSize);
        String  custName = null;
        String title = null;
        String linkman = null;
        if(object != null ){
            custName = object.getString("custName").trim();
            title = object.getString("title").trim();
            linkman = object.getString("linkman").trim();
        }

        List<Market> markets = marketMapper.getAllMarket(custName,title,linkman);
        PageInfo<Market> pageInfo = new PageInfo<>(markets);
        PageResult pageResult = new PageResult(pageIndex , pageSize , Integer.parseInt(pageInfo.getTotal()+""),pageInfo.getList());
        return pageResult;
    }

    /**
     * 添加
     * @param market
     */
    public void  addMarket(Market market){
        marketMapper.addMarket(market);
    }

    /**
     * 修改
     * @param market
     */
    public void updateMarket(Market market){
        marketMapper.updateMarket(market);

    }

    /*
    删除
     */
    public void deletMarket(Integer id){
        marketMapper.deletMarket(id);
    }
}
