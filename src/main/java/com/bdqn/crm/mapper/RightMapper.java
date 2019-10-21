package com.bdqn.crm.mapper;

import com.bdqn.crm.model.Right;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author 忍
 * @title: RightMapper
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1722:50
 */
public interface RightMapper extends BaseMapper<Right> {
    List<Right> getRightByRole(Long roleId);
}
