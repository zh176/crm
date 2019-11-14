package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//客户流失表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String custNo;
    private String custManagerId;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date lastOrderDate;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date lostDate;
    private String delay;
    private String reason;
    private String status;
}
