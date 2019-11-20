package com.bdqn.crm.service;

import com.bdqn.crm.exception.MyRuntimeException;
import com.bdqn.crm.mapper.PlaneMapper;
import com.bdqn.crm.model.Market;
import com.bdqn.crm.model.Plane;
import com.bdqn.crm.utils.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @author 忍
 * @title: PlaneService
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/1820:42
 */
@Service
public class PlaneService {
    @Autowired
    PlaneMapper planeMapper;

    public Integer addPlane(Plane plane){
        if (plane!=null){
            plane.setCreateTime(new Date(System.currentTimeMillis()));
            Integer planId = planeMapper.addPlane(plane);
            return plane.getId();
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));    }

    public boolean updPlane(Plane plane){
        if (plane!=null){
            boolean b = planeMapper.updPlane(plane);
            return b;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public boolean delPlane(Integer id){
        if (id!=null){
            boolean b = planeMapper.delPlane(id);
            return b;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }

    public List<Plane> getPlaneByMarkId(Integer markId){
        if (markId!=null){
            List<Plane> planes = planeMapper.getPlanByMarkId(markId);
            return planes;
        }
        throw new MyRuntimeException(ResultView.error("参数异常"));
    }
}
