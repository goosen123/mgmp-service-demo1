package com.goosen.commons.exception;

import com.goosen.commons.enums.BusinessExceptionEnum;
import com.goosen.commons.enums.ResultCode;
import com.goosen.commons.utils.StringUtil;

/**
 * 业务异常类
 * @author Goosen
 * @since 2018-05-31 pm
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 194906846739586856L;

	protected String code;

	protected String message;

	protected ResultCode resultCode;

	protected Object data;

	public BusinessException() {
		BusinessExceptionEnum exceptionEnum = BusinessExceptionEnum.getByEClass(this.getClass());
		if (exceptionEnum != null) {
			resultCode = exceptionEnum.getResultCode();
			code = exceptionEnum.getResultCode().code().toString();
			message = exceptionEnum.getResultCode().message();
		}

	}

	public BusinessException(String message) {
		this();
		this.message = message;
	}

	public BusinessException(String format, Object... objects) {
		this();
		this.message = StringUtil.formatIfArgs(format, "{}", objects);
	}

	public BusinessException(ResultCode resultCode, Object data) {
		this(resultCode);
		this.data = data;
	}

	public BusinessException(ResultCode resultCode) {
		this.resultCode = resultCode;
		this.code = resultCode.code().toString();
		this.message = resultCode.message();
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
