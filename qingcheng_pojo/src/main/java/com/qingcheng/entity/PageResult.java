package com.qingcheng.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 自定义封装的对象PageResult实体类
 */
public class PageResult<T> implements Serializable {

    private long total;

    private List<T> rows;

   /* 构造方法*/
    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    /*get和set方法*/
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
