package com.bdqn.crm.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 忍
 * @title: PayloadBo
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1716:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayloadBo {
    private Long userId;
    private String userName;
    private Integer roleId;
    private String roleName;
    private String header;
}
