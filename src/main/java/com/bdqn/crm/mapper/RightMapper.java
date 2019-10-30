package com.bdqn.crm.mapper;

import com.bdqn.crm.model.Right;
import com.bdqn.crm.model.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author 忍
 * @title: RightMapper
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1722:50
 */
@Repository
public interface RightMapper extends BaseMapper<Right> {
    List<Right> getRightByRole(Long roleId);

    /**
     * 获取所有菜单
     * @return
     */
    List<Right> getAllRight();

}
