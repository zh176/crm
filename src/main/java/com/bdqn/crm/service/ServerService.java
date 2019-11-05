package com.bdqn.crm.service;

import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.ServerMapper;
import com.bdqn.crm.model.Server;
import com.bdqn.crm.utils.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 忍
 * @title: ServerService
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/511:16
 */
@Service
public class ServerService {
    @Autowired
    ServerMapper serverMapper;

    public boolean createServer(Server server){
        if(server!=null){
            boolean b = serverMapper.creatServer(server);
            return b;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }
}
