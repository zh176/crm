package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 忍
 * @title: User
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1614:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
    private String password;
    private String phone;
    private Integer roleId;
    private String header;
    private Date creatTime;
    private boolean flag;
}
