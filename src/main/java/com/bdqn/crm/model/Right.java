package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 忍
 * @title: Right
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1614:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Right implements Serializable {
    private Integer code;
    private Integer parentCode;
    private  String type;
    private String text;
    private String url;
    private String tip;
}
