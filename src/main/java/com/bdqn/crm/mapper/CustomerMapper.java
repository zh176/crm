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

    /**
     * 获取暂缓流失，确认流失 的客户
     * @param name
     * @param managerName
     * @param status
     * @return
     */
    List<Customer> getLost(String name,String managerName,String status);

    /**
     * 添加客户流失对象
     * @param customer
     * @return
     */
    boolean addCustomer(Customer customer);

    /**
     * 根据客户id更改订单状态
     * @param custId
     * @return
     */
    boolean updOrder(String custId);

    /**
     * 根据id获取客户流失数据
     * @param id
     * @return
     */
    Customer getCustomerById(String id);

    /**
     * 确认流失
     * @param customer
     * @return
     */
    boolean affirmLost(Customer customer);
}
