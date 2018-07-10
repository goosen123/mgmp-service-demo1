package com.goosen.commons.model.commons;


/**
 * 参数无效提示实体
 * @author Goosen
 * 2018年6月27日 -下午2:36:15
 */
public class ParameterInvalidItem {

	/**
	 * 无效字段的名称
	 */
	private String fieldName;

	/**
	 * 错误信息
	 */
	private String message;
	
	public ParameterInvalidItem() {
		
	}
	
	public ParameterInvalidItem(String fieldName,String message) {
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
