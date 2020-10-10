/*
 * Copyright (c) 2020 牧星仓库管理系统 All rights reserved.
 *
 * http://www.mushiny.com
 *
 * 版权所有，侵权必究！
 */

package com.mushiny.workbin.exception;

import java.io.Serializable;

/**
 * 响应数据
 *
 * @author Elen elen.shen@mushiny.comn
 * @since 2.1.0
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编码：0表示成功，其他值表示失败
     */
    private int code = 0;

    /**
     * 消息内容
     */
    private String msg = "success";

    /**
     * 响应数据
     */
    private T data;

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public boolean success() {
        return code == 0;
    }

    public Result<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
