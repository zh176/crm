package com.bdqn.crm.service;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.MarketMapper;
import com.bdqn.crm.model.Market;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
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
        return marketMapper.MarketById(id);

    }

    /**
     * 查询
     * @return
     */
    public PageResult getAllMarket(PagePrarm pagePrarm){
        int pageIndex = pagePrarm.getPageIndex();
        Integer pageSize = pagePrarm.getPageSize();

        Market market = JSONObject.parseObject(pagePrarm.getCondition(), Market.class);
        PageHelper.startPage(pageIndex,pageSize);
        List<Market> markets = marketMapper.getAllMarket(market);
        PageInfo<Market> pageInfo = new PageInfo<>(markets);
        PageResult pageResult = new PageResult(pageIndex , pageSize , Integer.parseInt(pageInfo.getTotal()+""),pageInfo.getList());
        return pageResult;
    }

    /**
     * 添加
     * @param market
     */
    public boolean  addMarket(Market market){
        market.setCreateDate(new Date());
        boolean b = marketMapper.addMarket(market);
        return b;
    }

    /**
     * 修改
     * @param
     */
    public boolean updateMarket(Market market){
        try {
            if (market != null){
                marketMapper.updateMarket(market);
                return true;
            }
            throw new MyRuntimeException(ResultView.error("参数异常"));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
    删除
     */
    public boolean deletMarket(Integer id){
        marketMapper.deletMarket(id);
        return true;
    }

    public boolean allotChance(Market market){
        if (market!=null){
            market.setDueDate(new Date());
            boolean b = marketMapper.allotChance(market);
            return b;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }
}
