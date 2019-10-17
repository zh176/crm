package com.bdqn.crm.mapper;

import com.bdqn.crm.model.RoleRight;
import com.bdqn.crm.utils.result.PagePrarm;
import org.apache.ibatis.annotations.Mapper;
import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author 忍
 * @title: UserMapper
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/1623:06
 */
@Component
public interface RoleRightMapper {
    List<RoleRight> getAll();
}
