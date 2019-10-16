package com.bdqn.crm.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 忍
 * @title: PageResult
 * @projectName crm-project
 * @description: 分页结果
 * @date 2019/10/1521:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {
    /**
     * 当前页
     */
    private Integer pageIndex;
    /**
     * 当前页多少数据
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Integer total;
    /**
     * 记录
     */
    private List records;
}
