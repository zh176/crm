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
@Repository
public interface RoleRightMapper extends BaseMapper<RoleRight> {
    /**
     * 根据权限id-菜单编号获取操作
     * @param roleId 权限id
     * @param rightCode 菜单编号
     * @return 可操作的字符串
     */
    String getOperate(long roleId,String rightCode);
}
