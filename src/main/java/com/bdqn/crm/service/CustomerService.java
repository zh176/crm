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


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    private <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public PageResult getLostEarly(PagePrarm pagePrarm){
        Integer pageIndex = pagePrarm.getPageIndex();
        Integer pageSize = pagePrarm.getPageSize();

        JSONObject object = JSONObject.parseObject(pagePrarm.getCondition());
        PageHelper.startPage(pageIndex,pageSize);
        String name=null;
        String managerName = null;
        String status=null;
        if (object!=null){
            name=object.getString("name").trim();
            managerName = object.getString("managerName").trim();
            status = object.getString("status");
        }

        List<Customer> lostEarly = null;
        if (status!=null && status.equals("lost_early")){
            lostEarly = customerMapper.getLostEarly(name, managerName);
            lostEarly = lostEarly.stream().filter(distinctByKey(Customer::getCustNo)).collect(Collectors.toList());
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

    public boolean addCustomer(Customer customer){
        if (customer!=null){
            customer.setLostDate(null);
            customer.setLastOrderDate(new Date(Long.parseLong(customer.getTime())));
            System.out.println(customer.getCustNo());
            customerMapper.updOrder(customer.getCustNo());
            boolean flag = customerMapper.addCustomer(customer);
            return flag;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public Customer getLost(String id){
        if (id!=null){
            Customer customer = customerMapper.getCustomerById(id);
            return customer;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public boolean affirmLost(Customer customer){
        if (customer!=null){
            customer.setLostDate(new Date());
            boolean b = customerMapper.affirmLost(customer);
            return b;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }
}
