package com.bdqn.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 忍
 * @title: OauthToken
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/1111:02
 */
@AllArgsConstructor
@Data
public class AuthToken {
    private String id;
    private String userId;
    private String token;
}
