package com.bdqn.crm.service;

import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.RoleRightMapper;
import com.bdqn.crm.model.RoleRight;
import com.bdqn.crm.utils.result.PagePrarm;
import com.bdqn.crm.utils.result.PageResult;
import com.bdqn.crm.utils.result.ResultEnum;
import com.bdqn.crm.utils.result.ResultView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author 忍
 * @title: RoleRight
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/179:14
 */
@Service
public class RoleRightService {

    @Autowired
    RoleRightMapper roleRightMapper;

    public String getRoleRightByRole(Long roleId, String roleCode) {
        String operate = roleRightMapper.getOperate(roleId, roleCode);
        if (StringUtils.isEmpty(operate)){
            throw new MyRuntimeException(ResultView.error(ResultEnum.CODE_12));
        }
        return operate;
    }
}
