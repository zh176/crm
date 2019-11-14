package com.bdqn.crm.mapper;

import com.bdqn.crm.model.Client;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
public interface ClientMapper extends BaseMapper<Client> {

    /**
     * 根据客户编号，客户名称，客户地址，客户经理id查询客户信息
     * @param name 客户名称
     * @param no 客户编号
     * @param region 客户地址
     * @param managerId 客户经理id
     * @return
     */
    List<Client> findClient(String name,String no,String region,long managerId,String levelLabel);

    /**
     *修改客户信息
     * @param client
     */
    boolean updateClient(Client client);

    /**
     * 删除客户信息
     * @param no
     */
    boolean deleteClient(String no);

    /**
     * 添加客户信息
     * @param client
     */
    boolean addClient(Client client);

    /**
     * 查询所有客户
     * @return
     */
    List<Client> getAllClient(String no,String name,String region,String managerName,Integer level);

    /**
     * 根据id查询客户
     * @param no
     * @return
     */
    Client getClientByNo(String no);
}
