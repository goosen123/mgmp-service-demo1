package com.goosen.commons.utils;

import java.util.regex.Pattern;

import com.goosen.commons.enums.ResultCode;
import com.goosen.commons.exception.BusinessException;
import com.goosen.commons.model.commons.ParameterInvalidItem;


/**
 * 参数校验工具类
 * @author Goosen
 * 2018年6月28日 -下午6:26:00
 */
public class CheckUtil {

	public static void check(boolean condition, String fieldName,String message) {
		if (!condition) {
			fail(fieldName,message);
		}
	}

	public static void notEmpty(String str,String fieldName,String message) {
		if (str == null || str.isEmpty()) {
			fail(fieldName,message);
		}
	}

	public static void notNull(Object obj, String fieldName,String message) {
		if (obj == null) {
			fail(fieldName,message);
		}
	}
	
	public static void moneyValue(Double value, String fieldName,String message) {
		if (value == null) {
			fail(fieldName,message);
			return;
		}
		String moneyReg = "^\\d+(\\.\\d{1,2})?$";//表示金额的正则表达式  
		Pattern moneyPattern = Pattern.compile(moneyReg); 
		if (moneyPattern.matcher(value.toString()).matches()) {
			fail(fieldName,message);
		}
	}
	
	public static void isVaileNum(Integer num, String fieldName,String message) {
		if (!CommonUtil.isVaileNum(num)) {
			fail(fieldName,message);
		}
	}

	private static void fail(String fieldName, String message) {
		throw new BusinessException(ResultCode.PARAM_IS_INVALID,new ParameterInvalidItem(fieldName,message));
	}
}
