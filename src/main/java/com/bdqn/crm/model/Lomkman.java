package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//客户的联系人表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lomkman {
    private Integer id;
    private String custNo;
    private String name;
    private String sex;
    private String postion;
    private String kel;
    private String mobile;
    private String memo;
}
