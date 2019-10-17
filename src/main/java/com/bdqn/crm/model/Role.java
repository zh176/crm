package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 忍
 * @title: Role
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1614:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private boolean flag;
}
