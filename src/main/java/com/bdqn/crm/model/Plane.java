package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author 忍
 * @title: Plane
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/1820:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plane {
    private Integer id;
    private Integer markId;
    private Date createTime;
    private String todo;
    private String result;
}
