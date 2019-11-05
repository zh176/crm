package com.bdqn.crm.mapper;

import com.bdqn.crm.model.DataDictionaries;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataDictionariesMapper {
    /**
     * 查询数据字典信息
     * @return
     */
    List<DataDictionaries>  getAllDataDictionaries();

    /**
     * 添加数据字典信息
     * @param dataDictionaries
     */
    void addDataDictionaries(DataDictionaries dataDictionaries);

    /**
     * 删除数据字典信息
     * @param id
     */
    void deletDataDictionaries(Integer id);

    /**
     * 修改数据字典信息
     * @param dataDictionaries
     */
    void updateDataDictionaries(DataDictionaries dataDictionaries);
}
