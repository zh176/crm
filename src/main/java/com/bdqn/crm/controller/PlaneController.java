package com.bdqn.crm.controller;

import com.bdqn.crm.model.Plane;
import com.bdqn.crm.service.PlaneService;
import com.bdqn.crm.utils.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 忍
 * @title: PlaneController
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/1820:40
 */
@RestController
@RequestMapping("/plane")
public class PlaneController {
    @Autowired
    PlaneService planeService;

    @PostMapping("/add")
    public ResultView addPlane(Plane plane){
        Integer planeId = planeService.addPlane(plane);
        return ResultView.success(planeId);
    }
    @PutMapping("/upd")
    public ResultView updPlane(Plane plane){
        boolean b = planeService.updPlane(plane);
        return ResultView.success(b);
    }
    @DeleteMapping("/del/{id}")
    public ResultView delPlane(@PathVariable Integer id){
        boolean b = planeService.delPlane(id);
        return ResultView.success(b);
    }
    @GetMapping("/{markId}")
    public ResultView getPlaneByMarkId(@PathVariable Integer markId){
        List<Plane> planes = planeService.getPlaneByMarkId(markId);
        return ResultView.success(planes);
    }
}
