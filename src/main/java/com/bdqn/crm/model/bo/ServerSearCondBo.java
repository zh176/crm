package com.bdqn.crm.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

/**
 * @author 忍
 * @title: ServerSearCondBo
 * @projectName crm-project
 * @description: 服务模块的搜索条件类
 * @date 2019/11/523:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerSearCondBo {
    private String custNo;
    private String status;
    private String title;
    private String type;
    private Date startTime;
    private Date endTime;
    private String state;
    private String userId;
}
