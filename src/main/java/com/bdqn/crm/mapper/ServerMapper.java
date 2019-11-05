package com.bdqn.crm.mapper;

import com.bdqn.crm.model.Server;
import org.springframework.stereotype.Repository;

/**
 * @author 忍
 * @title: ServerMapper
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/511:02
 */
@Repository
public interface ServerMapper {

    /**
     * 创建服务
     * @param server
     * @return
     */
    boolean creatServer(Server server);
}
