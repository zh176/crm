package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//销售机会表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Market {
    private Integer id;
    private String source;
    private String custName;
    private String title;
    private Integer rate;
    private String linkman;
    private String tel;
    private String desc;
    private Integer createId;
    private String createName;
    private Date createDate;
    private Integer dueId;
    private String dueName;
    private Date dueDate;
    private String status;
}
