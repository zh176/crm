package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
    private Integer id;
    private String name;
    private String password;
    private Integer roleId;
    private boolean flag;
}
