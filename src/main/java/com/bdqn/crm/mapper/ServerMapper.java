package com.bdqn.crm.mapper;

import com.bdqn.crm.model.Server;
import com.bdqn.crm.model.bo.ServerSearCondBo;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

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

    /**
     * 获取所有服务
     * @param serverSearCondBo
     * @return
     */
    List<Server> getAllServer(ServerSearCondBo serverSearCondBo);

    /**
     * 分配服务
     * @param server
     * @return
     */
    boolean allotServer(Server server);

    /**
     * 根据id删除服务
     * @param serverId
     * @return
     */
    boolean delServer(Integer serverId);

    /**
     * 根据id获取服务
     * @param serverId
     * @return
     */
    Server getServerById(Integer serverId);

    /**
     * 服务处理
     * @param server
     * @return
     */
    boolean disposeServer(Server server);

    /**
     * 服务反馈
     * @param server
     * @return
     */
    boolean feedbackServer(Server server);
}
