package com.bdqn.crm.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 忍
 * @title: PagePrarm
 * @projectName crm-project
 * @description: 分页参数类
 * @date 2019/10/1521:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagePrarm {
    /**
     * 当前页数
     */
    private int pageIndex;
    /**
     * 当前页有多少数据
     */
    private int pageSize;
    /**
     * 要查的字段(model的属性名)
     */
    private String sqlColumns;
    /**
     * 排序
     */
    private String sort;
    /**
     * 条件
     */
    private String condition;
    public int getPageStart(){
        if (pageIndex > 0){
            return (pageIndex - 1) * pageSize;
        }
        return pageIndex;
    }
}
