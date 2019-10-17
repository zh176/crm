package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//库存表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Integer id;
    private Integer prodId;
    private String warehouse;
    private String ware;
    private Integer count;
    private String memo;
}
