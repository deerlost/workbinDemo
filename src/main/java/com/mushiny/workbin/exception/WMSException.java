/*
 * Copyright (c) 2020 牧星仓库管理系统 All rights reserved.
 *
 * http://www.mushiny.com
 *
 * 版权所有，侵权必究！
 */

package com.mushiny.workbin.exception;

/**
 * 自定义异常
 *
 * @author Elen elen.shen@mushiny.comn
 * @since 2.1.0
 */
public class WMSException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int code;
	private String msg;

	public WMSException(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public WMSException(String msg) {
		this.code = 10001;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}