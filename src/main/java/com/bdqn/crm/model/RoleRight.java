package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 忍
 * @title: RoleRight
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1614:54
 */
@Data
@AllArgsConstructor@NoArgsConstructor
public class RoleRight implements Serializable {
    private Integer id;
    private Integer roleId;
    private String rightCode;
    private String operate;
}
