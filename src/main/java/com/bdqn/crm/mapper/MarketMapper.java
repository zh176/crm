package com.bdqn.crm.mapper;

import com.bdqn.crm.model.Market;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;

@Repository
public interface MarketMapper {
    /**
     * 根据ID删除信息
     * @param id
     * @return
     */
    Market MarketById(Integer id);

    /**
     * 查询
     * @return
     */
    List<Market> getAllMarket(String custName, String title,String linkman);

    /**
     * 添加
     * @param market
     */
    void addMarket(Market market);

    /**
     * 删除
     * @param id
     */
    void deletMarket(Integer id);

    /**
     * 修改
     * @param market
     */
    void updateMarket(Market market);


}
