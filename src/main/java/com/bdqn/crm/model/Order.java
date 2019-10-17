package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//客户订单表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private String custNo;
    private Date date;
    private String addr;
    private String status;
}
