package com.goosen.commons.utils;

import java.math.BigDecimal;

/**
 * 数值类型计算操作工具
 * 2018-04-25 17:47:01
 * @author Goosen
 *
 */
public class NumberUtil {

	private NumberUtil(){};
	
	/**
	 * 加法
	 * @param value1
	 * @param value2
	 * @param accuracy
	 * @return
	 */
	public static Double add(Double value1, Double value2, int accuracy){
		if(value1 == null){
			value1 = 0.0;
		}
		if(value2 == null){
			value2 = 0.0;
		}
		BigDecimal value1B = new BigDecimal(value1);
		BigDecimal value2B = new BigDecimal(value2);
		value1B = value1B.add(value2B);
		value1B = value1B.setScale(accuracy,BigDecimal.ROUND_HALF_UP);
		return value1B.doubleValue();
	}
	
	/**
	 * 减法（第一个减去第二个）
	 * @param value1
	 * @param value2
	 * @param accuracy
	 * @return
	 */
	public static Double substract(Double value1, Double value2, int accuracy){
		if(value1 == null){
			value1 = 0.0;
		}
		if(value2 == null){
			value2 = 0.0;
		}
		BigDecimal value1B = new BigDecimal(value1);
		BigDecimal value2B = new BigDecimal(value2);
		value1B = value1B.subtract(value2B);
		value1B = value1B.setScale(accuracy,BigDecimal.ROUND_HALF_UP);
		return value1B.doubleValue();
	}
	
	/**
	 * 乘法
	 * @param value1
	 * @param value2
	 * @param accuracy
	 * @return
	 */
	public static Double multi(Double value1, Double value2, int accuracy){
		if(null == value1 || value2 == null)
			return null;
		BigDecimal value1B = new BigDecimal(value1);
		BigDecimal value2B = new BigDecimal(value2);
		value1B = value1B.multiply(value2B);
		value1B = value1B.setScale(accuracy,BigDecimal.ROUND_HALF_UP);
		return value1B.doubleValue();
	}
	
	/**
	 * 除法（第一个除以第二个）
	 * @param value1
	 * @param value2
	 * @param accuracy
	 * @return
	 */
	public static Double division(Double value1, Double value2, int accuracy){
		if(null == value1 || value2 == null)
			return null;
		if(value2 == 0.0){
			return 0.0;
		}
		BigDecimal value1B = new BigDecimal(value1);
		BigDecimal value2B = new BigDecimal(value2);
		int accuracy1 = accuracy + 1;
		value1B = value1B.divide(value2B,accuracy1, BigDecimal.ROUND_HALF_EVEN);
		value1B = value1B.setScale(accuracy,BigDecimal.ROUND_HALF_UP);
		return value1B.doubleValue();
	}
	
	/**
	 * 四舍五入指定位小数
	 * @param val
	 * @param accuracy
	 * @return
	 */
	public static Double upDouble(Double val, int accuracy){
		BigDecimal valB = new BigDecimal(val);
		valB = valB.setScale(accuracy,BigDecimal.ROUND_HALF_UP);
		return valB.doubleValue();
	}
	
}
