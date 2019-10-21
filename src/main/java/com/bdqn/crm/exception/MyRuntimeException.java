package com.bdqn.crm.exception;

import com.bdqn.crm.utils.result.ResultView;
import lombok.Data;

/**
 * @author 忍
 * @title: MyRuntimeExciption
 * @projectName crm-project
 * @description:  自定义运行时异常类
 * @date 2019/10/1717:01
 */
@Data
public class MyRuntimeException extends RuntimeException{
    private ResultView resultView;
    public MyRuntimeException(ResultView resultView){
        super(resultView.getMsg());
        this.resultView = resultView;
    }
}
