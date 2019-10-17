package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//交往记录
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private Integer id;
    private String custNo;
    private Date date;
    private String plce;
    private String title;
    private String desc;
}
