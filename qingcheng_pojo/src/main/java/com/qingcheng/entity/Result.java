package com.qingcheng.entity;

import java.io.Serializable;

/**
 * 业务返回结果对象封装,判断成功或失败
 */
public class Result implements Serializable {

    private Integer code;//业务返回码，0：成功，1：错误

    private String message;//信息

    /*无参数构造方法，让该对象在new完对象之后，能有默认值*/
    public Result() {
        this.code = 0;
        this.message = "执行成功";
    }

    /*有参数构造方法*/
    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /* get和set方法*/
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
