package com.bdqn.crm.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.ServerMapper;
import com.bdqn.crm.model.Server;
import com.bdqn.crm.model.bo.ServerSearCondBo;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
            server.setCreateDate(new Date());
            boolean b = serverMapper.creatServer(server);
            return b;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public PageResult getAllServer(PagePrarm pagePrarm){
        int pageIndex = pagePrarm.getPageIndex();
        int pageSize = pagePrarm.getPageSize();
        PageHelper.startPage(pageIndex,pageSize);
        String condition = pagePrarm.getCondition();
        ServerSearCondBo serverSearCondBo = new ServerSearCondBo();
        if (condition!=null){
            serverSearCondBo = JSON.parseObject(condition,ServerSearCondBo.class);
        }
        List<Server> servers = serverMapper.getAllServer(serverSearCondBo);
        PageInfo<Server> serverPageInfo = new PageInfo<>(servers);
        PageResult pageResult = new PageResult(pageIndex, pageSize, Integer.valueOf(serverPageInfo.getTotal() + ""),
                serverPageInfo.getList());
        return pageResult;
    }

    public boolean allotServer(Server server){
        if (server!=null){
            server.setDueDate(new Date());
            boolean b = serverMapper.allotServer(server);
            return b;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public boolean delServer(Integer serverId){
        if (serverId!=null){
            boolean b = serverMapper.delServer(serverId);
            return b;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public Server getServerById(Integer serverId){
        if (serverId!=null){
            Server server = serverMapper.getServerById(serverId);
            return server;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public boolean disposeServer(Server server){
        if (server!=null){
            boolean b = serverMapper.disposeServer(server);
            return b;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public boolean feedbackServer(Server server){
        if (server!=null){
            server.setResultDate(new Date());
            boolean b = serverMapper.feedbackServer(server);
            return b;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }
}
