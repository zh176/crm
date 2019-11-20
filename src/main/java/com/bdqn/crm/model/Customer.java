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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String custManagerId;
    private Date lastOrderDate;
    private Date lostDate;
    private String delay;
    private String reason;
    private String status;
    private String time;

}
