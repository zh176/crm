package com.bdqn.crm.service;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.ClientMapper;
import com.bdqn.crm.model.Client;
import com.bdqn.crm.utils.CreateUtil;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientMapper clientMapper;
    public List<Client> findClient(String name,String no,String region,long managerId ,String levelLabel){
        List<Client> clients = clientMapper.findClient(name,no,region,managerId,levelLabel);
        if (clients==null){
            throw new MyRuntimeException(ResultView.error("抱歉，没有此客户"));
        }
        return clients;
    }

    public boolean updateClient(Client client){
        try {
            if (client != null){
                clientMapper.updateClient(client);
                return true;
            }
            throw new MyRuntimeException(ResultView.error("参数异常"));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteClient(String no){
        clientMapper.deleteClient(no);
        return true;
    }
    public boolean addClient(Client client) {
        client.setNo(CreateUtil.id()+"");
        clientMapper.addClient(client);
        client.setStatus("1");
        return true;
    }

    public PageResult getAllClient(PagePrarm pagePrarm){
        Integer pageIndex=pagePrarm.getPageIndex();
        Integer pageSize=pagePrarm.getPageSize();
        JSONObject object=JSONObject.parseObject(pagePrarm.getCondition());
        PageHelper.startPage(pageIndex,pageSize);
        String no=null;
        String name=null;
        String region=null;
        String managerName=null;
        Integer level=null;
        if (object!=null){
            no=object.getString("no");
            name=object.getString("name").trim();
            region=object.getString("region").trim();
            managerName=object.getString("managerName").trim();
            level=object.getInteger("level");
        }
        List<Client> clients=clientMapper.getAllClient(no,name,region,managerName,level);
        PageInfo<Client> pageInfo=new PageInfo<>(clients);
        PageResult pageResult=new PageResult(pageIndex,pageSize,Integer.parseInt(pageInfo.getTotal()+""),pageInfo.getList());
        return pageResult;
    }

    public Client getClientByNo(String no){
        return clientMapper.getClientByNo(no);
    }
}
