package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//客户表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String no;
    private String name;
    private String region;
    private Integer managerId;
    private String managerName;
    private Integer level;
    private String levelLabel;
    private Integer satisfy;
    private Integer credit;
    private String addr;
    private String zip;
    private String tel;
    private String fax;
    private String website;
    private String licenceNo;
    private String chieftain;
    private Integer bankroll;
    private Integer turnover;
    private String bank;
    private String bankAccount;
    private String nationalTaxNo;
    private String status;
}
