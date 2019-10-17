package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//客户流失表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String custNo;
    private Integer custManagerId;
    private String custManagerName;
    private Date lastOrderDate;
    private Date lostDate;
    private String delay;
    private String reason;
    private String status;
}
