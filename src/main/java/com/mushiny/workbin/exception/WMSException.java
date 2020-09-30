package com.mushiny.workbin.exception;


/**
 * WMS系统基础异常类自带一个异常码errorCode
 * 
 * @author ebola
 *
 */
public class WMSException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3549258026559432905L;
	protected String[] args;

	public WMSException() {
		super();
	}

	public WMSException(String... args) {
		super();
		this.args = args;
	}

	public String[] getArgs() {
		return args;
	}
}
