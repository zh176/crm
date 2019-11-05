package com.bdqn.crm.mapper;

import com.bdqn.crm.model.DataDic;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import javax.validation.constraints.Max;
import javax.xml.crypto.Data;
import java.util.List;

/**
 * @author 忍
 * @title: DataDic
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/50:22
 */
@Repository
public interface DataDicMapper{
    /**
     * 根据条件获取所有数据字典
     * @param dataDic
     * @return
     */
    //List<DataDic> getAllDataDic(DataDic dataDic);

    /**
     * 根据类型名获取数据字典
     * @param typeCode
     * @return
     */
    List<DataDic> getDataDicByType(String typeCode);
}
