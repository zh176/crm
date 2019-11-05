package com.bdqn.crm.controller;


import com.bdqn.crm.model.DataDictionaries;
import com.bdqn.crm.service.DataDictionariesService;
import com.bdqn.crm.utils.result.ResultView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("数据字典")
@RestController
@RequestMapping("/dataDictionaries")
public class DataDictionariesController {
    @Autowired
    DataDictionariesService dataDictionariesService;

    @ApiOperation(value = "查询信息")
    @GetMapping("/list")
    public ResultView getAllDataDictionaries(){
        List<DataDictionaries> dataDictionaries = dataDictionariesService.getAllDataDictionaries();
        return ResultView.success(dataDictionaries);
    }

    @ApiOperation(value = "添加信息")
    @PostMapping("/add")
    public String addDataDictionaries(DataDictionaries dataDictionaries){
        dataDictionariesService.addDataDictionaries(dataDictionaries);
        return "list";
    }

    @ApiOperation(value = "删除信息")
    @DeleteMapping("/delet")
    public String deletDataDictionaries(Integer id){
        dataDictionariesService.deletDataDictionaries(id);
        return "list";
    }

    @ApiOperation(value = "修改信息")
    @PostMapping("/updates")
    public String updateDataDictionaries(DataDictionaries dataDictionaries){
        dataDictionariesService.updateDataDictionaries(dataDictionaries);
        return "list";
    }
}
