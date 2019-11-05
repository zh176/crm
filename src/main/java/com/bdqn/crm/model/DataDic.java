package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 数据字典表
 * @author 忍
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDic {
    private Integer id;
    private String typeCode;
    private String typeName;
    private String valueId;
    private String valueName;
    private Date creatTime;
    private boolean state;
}
