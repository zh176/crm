package com.bdqn.crm.service;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.CustomerMapper;
import com.bdqn.crm.model.Customer;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    public PageResult getLostEarly(PagePrarm pagePrarm){
        Integer pageIndex = pagePrarm.getPageIndex();
        Integer pageSize = pagePrarm.getPageSize();

        JSONObject object = JSONObject.parseObject(pagePrarm.getCondition());
        PageHelper.startPage(pageIndex,pageSize);
        String name=null;
        String managerName = null;
        String status=null;
        String no=null;
        if (object!=null){
            name=object.getString("name").trim();
            managerName = object.getString("managerName").trim();
            status = object.getString("status");
        }

        List<Customer> lostEarly = null;
        if (status.equals("lost_early")){
            lostEarly = customerMapper.getLostEarly(name, managerName);
        }else {
            lostEarly=customerMapper.getLost(name,managerName,status);
        }
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(lostEarly);
        PageResult pageResult=new PageResult(pageIndex,pageSize,Integer.parseInt(pageInfo.getTotal()+""),pageInfo.getList());
        return pageResult;
    }

    public boolean updCustomer(Customer customer){
        try {
            if (customer != null){
                customerMapper.updCustomer(customer);
                return true;
            }
            throw new MyRuntimeException(ResultView.error("参数异常"));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
