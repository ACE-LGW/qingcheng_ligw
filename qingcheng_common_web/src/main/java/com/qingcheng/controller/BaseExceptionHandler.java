package com.qingcheng.controller;

import com.qingcheng.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ControllerAdvice表示这是控制器的通知类
 */
@ControllerAdvice
public class BaseExceptionHandler {
   /* ExceptionHandler用来监测异常类型,Exception.class指定所有异常都会经过这个方法*/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();//控制台打印异常
        System.out.println("调用了异常处理！！！");
        return new Result(1,e.getMessage());//返回异常信息
    }
}
