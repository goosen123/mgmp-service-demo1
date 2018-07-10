package com.goosen.commons.exception;


import com.goosen.commons.enums.ResultCode;

/**
 * 数据没有找到异常
 * @author Goosen
 * @since 2018-05-31 pm
 */
public class DataNotFoundException extends BusinessException {

	private static final long serialVersionUID = 3721036867889297081L;

	public DataNotFoundException() {
		super();
	}

	public DataNotFoundException(Object data) {
		super();
		super.data = data;
	}

	public DataNotFoundException(ResultCode resultCode) {
		super(resultCode);
	}

	public DataNotFoundException(ResultCode resultCode, Object data) {
		super(resultCode, data);
	}

	public DataNotFoundException(String msg) {
		super(msg);
	}

	public DataNotFoundException(String formatMsg, Object... objects) {
		super(formatMsg, objects);
	}

}
