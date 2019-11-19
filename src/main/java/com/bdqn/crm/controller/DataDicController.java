package com.bdqn.crm.controller;

import com.bdqn.crm.model.DataDic;
import com.bdqn.crm.service.DataDicService;
import com.bdqn.crm.utils.result.ResultView;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 忍
 * @title: DataDicController
 * @projectName crm-project
 * @description: TODO
 * @date 2019/11/50:43
 */
@RestController
@RequestMapping("/dic")
@Api("数据字典操作控制器")
public class DataDicController {

    @Autowired
    private DataDicService dataDicService;

    @GetMapping("/{typeCode}")
    public ResultView getDIcByTypeCode(@PathVariable String typeCode){
        List<DataDic> dics = dataDicService.getDicByTypeCode(typeCode);
        return ResultView.success(dics);
    }

    @GetMapping("/value/{valueId}")
    public ResultView getValueNameById(@PathVariable String valueId){
        String valueName = dataDicService.getValueNameById(valueId);
        return ResultView.success(valueName);
    }

    @PostMapping("/add")
    public ResultView addDataDic(DataDic dataDic){
        boolean b = dataDicService.addDataDic(dataDic);
        return ResultView.success(b);
    }
}
