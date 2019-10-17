package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//订单连接表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderConnect {
    private Integer id;
    private Integer orderId;
    private Integer prodId;
    private Integer count;
    private String unit;
    private Double price;
}
