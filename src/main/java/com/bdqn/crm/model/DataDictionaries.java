package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//数据字典表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDictionaries {
    private Integer id;
    private String type;
    private String item;
    private String value;
    private Boolean isEditable;
}
