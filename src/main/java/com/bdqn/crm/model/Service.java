package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//客户服务表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private Integer id;
    private String type;
    private String title;
    private String custNo;
    private String status;
    private String request;
    private Integer createId;
    private String createName;
    private Date createDate;
    private Integer dueId;
    private String dueName;
    private Date dueDate;
    private String deal;
    private Integer dealId;
    private String dealName;
    private Date resultDate;
    private String result;
    private Integer satisfy;
}
