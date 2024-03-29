package com.bdqn.crm.controller;

import com.bdqn.crm.model.Customer;
import com.bdqn.crm.service.CustomerService;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.PastOrPresent;
import java.util.List;

@Api("客户流失信息")
@RequestMapping("/customer")
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "客户流失信息")
    @GetMapping("/all")
    public ResultView getLostEarly(PagePrarm pagePrarm){
        PageResult pageResult=customerService.getLostEarly(pagePrarm);
        return ResultView.success(pageResult);
    }

    @ApiOperation(value = "修改客户信息")
    @PutMapping("/upd")
    public ResultView updateClient(@RequestBody Customer customer){
        boolean result = customerService.updCustomer(customer);
        return ResultView.success(result);
    }

    @PostMapping("/add")
    public ResultView addCustomer(Customer customer){
        boolean b = customerService.addCustomer(customer);
        return ResultView.success(b);
    }

    @GetMapping("/{id}")
    public ResultView getCustomer(@PathVariable String id){
        Customer lost = customerService.getLost(id);
        return ResultView.success(lost);
    }

    @PostMapping("/affirm")
    public ResultView affirmLost(Customer customer){
        boolean b = customerService.affirmLost(customer);
        return ResultView.success(b);
    }
}
