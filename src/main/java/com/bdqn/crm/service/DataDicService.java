package com.bdqn.crm.service;

import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.DataDicMapper;
import com.bdqn.crm.model.DataDic;
import com.bdqn.crm.utils.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @author 忍
 * @title: DataDicService
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/50:40
 */
@Service
public class DataDicService {
    @Autowired
    private DataDicMapper dataDicMapper;

    public List<DataDic> getDicByTypeCode(String typeCode){
        if (typeCode!=null){
            List<DataDic> dataDics = dataDicMapper.getDataDicByType(typeCode);
            return dataDics;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public String getValueNameById(String valueId){
        if (valueId!=null){
            String valueName = dataDicMapper.getDicName(valueId);
            return valueName;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public boolean addDataDic(DataDic dataDic){
        if (dataDic!= null) {
            dataDic.setCreatTime(new Date(System.currentTimeMillis()));
            dataDicMapper.addDataDic(dataDic);
            return true;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }
}
