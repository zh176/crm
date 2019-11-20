package com.bdqn.crm.mapper;

import com.bdqn.crm.model.Plane;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author 忍
 * @title: PlaneMapper
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/1820:36
 */
@Repository
public interface PlaneMapper {
    /**
     * 添加计划
     * @param plane
     * @return
     */
    Integer addPlane(Plane plane);

    /**
     * 更新计划
     * @param plane
     * @return
     */
    boolean updPlane(Plane plane);

    /**
     * 删除计划
     * @param id
     * @return
     */
    boolean delPlane(Integer id);

    /**
     * 根据销售机会获取计划
     * @param markId
     * @return
     */
    List<Plane> getPlanByMarkId(Integer markId);
}