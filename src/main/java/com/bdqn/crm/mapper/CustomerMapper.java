package com.bdqn.crm.mapper;

import com.bdqn.crm.model.Customer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import java.util.List;

@Repository
public interface CustomerMapper extends BaseMapper<Customer> {

    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    boolean updCustomer(Customer customer);

    /**
     * 获取预警流失状态的客户
     * @param name
     * @param managerName
     * @return
     */
    List<Customer> getLostEarly(String name,String managerName);

    List<Customer> getLost(String name,String managerName,String status);
}
