package com.bdqn.crm.service;

import com.bdqn.crm.mapper.DataDictionariesMapper;
import com.bdqn.crm.model.DataDictionaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionariesService {
    @Autowired
    DataDictionariesMapper dataDictionariesMapper;

    /**
     * 查询
     * @return
     */
    public List<DataDictionaries> getAllDataDictionaries(){

        return dataDictionariesMapper.getAllDataDictionaries();
    }

    /**
     * 添加
     * @param dataDictionaries
     */
    public void addDataDictionaries(DataDictionaries dataDictionaries){
        dataDictionariesMapper.addDataDictionaries(dataDictionaries);
    }

    /**
     * 删除
     * @param id
     */
    public void deletDataDictionaries(Integer id){
        dataDictionariesMapper.deletDataDictionaries(id);
    }

    /**
     * 修改
     * @param dataDictionaries
     */
    public void updateDataDictionaries(DataDictionaries dataDictionaries){
        dataDictionariesMapper.updateDataDictionaries(dataDictionaries);
    }
}
