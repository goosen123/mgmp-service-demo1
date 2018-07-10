package com.goosen.commons.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * 常用工具类
 * 2018-04-23 16:55:01
 * @author Goosen
 */
public class CommonUtil {
	
	/**
	 * 判断数值是否大于0，也做了非空判断
	 * @param number:int long float double
	 * @return	是数值且大于0，true
	 */
	public static Boolean isVaileNum(Number number){
		if(null == number)
			return false;
		if(number instanceof Double){
			Double value = (Double) number;
			if(value > 0)
				return true;
		}else if(number instanceof Float){
			Float value = (Float) number;
			if(value > 0)
				return true;
		}else if(number instanceof Integer){
			Integer value = (Integer) number;
			if(value > 0)
				return true;
		}else if(number instanceof Long){
			Long value = (Long) number;
			if(value > 0)
				return true;
		}else{
			if(number.intValue() > 0)
				return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否是空
	 * @param str
	 * @return 空，true
	 */
	public static boolean isTrimNull(String str){
		if(null == str || str.trim().length() == 0)
			return true;
		return false;
	}
	
	/**
	 * 判断字符是否是空
	 * @param cs：CharBuffer、String、StringBuffer、StringBuilder
	 * @return
	 */
	public static boolean isEmpty(CharSequence cs) {
		return org.apache.commons.lang3.StringUtils.isEmpty(cs);
	}
	
	/**
	 * 判断集合是否为空 
	 * @param collection
	 * @return 空，true
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.size() == 0;
	}
	
	/**
	 * 判断键值对集合是否为空 
	 * @param collection
	 * @return 空，true
	 */
	public static boolean isEmpty(Map<?,?> map) {
		return map == null || map.size() == 0;
	}
	
	/**
	 * 返回容器中的key的字符串值
	 * @param map 容器
	 * @param key key
	 */
	public static String getStrValue(Map map, String key){
		if(null == map || map.size() == 0 || !map.containsKey(key) 
				|| key == null || isTrimNull(key)){
			return null;
		}
		Object valueObj = map.get(key);
		String value = getStrValue(valueObj);
		return value;
	}
	
	/**
	 * 返回该Map中的key的string值，没有则返回 expand
	 * @param map  容器
	 * @param key  key
	 * @param expand  期望值 
	 */
	public static String getStrValue(Map map, String key,String expand){
		String str = getStrValue(map,key);
		if(CommonUtil.isTrimNull(str)){
			return expand;
		}else{
			return str;
		}
	}
	
	/**
	 * 返回该对象的string字符串
	 * @param obj
	 * @return
	 */
	public static String getStrValue(Object obj){
		if(null == obj){
			return null;
		}
		String strValue = null;
		
		if(obj instanceof String){
			strValue = (String) obj;
		}else if(obj instanceof Integer){
			Integer intValue = (Integer) obj;
			strValue = intValue + "";
		}else if(obj instanceof Double){
			Double dValue = (Double) obj;
			strValue = dValue + "";
		}else if(obj instanceof Float){
			Float fValue = (Float) obj;
			strValue = fValue + "";
		}else if(obj instanceof Long){
			Long lValue = (Long) obj;
			strValue = lValue + "";
		}else if(obj instanceof Date){
			Date dValue = (Date) obj;
			strValue = DateUtil.convert2String(dValue, "yyyy-MM-dd HH:mm:ss");
		}else if(obj instanceof BigDecimal){
			BigDecimal big = (BigDecimal) obj;
			strValue = big.toString();
		}else if(obj instanceof Vector){
			//Vector vec = (Vector) obj;
			strValue = JsonUtil.toJSONString(obj);
		}else if(obj instanceof Map){
			//Map map = (Map) obj;
			strValue = JsonUtil.toJSONString(obj);
		}else if(obj instanceof List){
			//List list = (List) obj;
			strValue = JsonUtil.toJSONString(obj);
		}
		return strValue;
	}
	
	/**
	 * 返回容器key的Int值
	 * @param map 容器
	 * @param key key
	 * @return
	 */
	public static Integer getIntValue(Map map, String key){
		if(null == map || map.size() == 0 || !map.containsKey(key) 
				|| key == null || isTrimNull(key)){
			return null;
		}
		Object valueObj = map.get(key);
		Integer value = getIntValue(valueObj);
		return value;
	}
	
	/**
	 * 返回容器key的Int值
	 * @param map 容器
	 * @param key key
	 * @param expand 期望值
	 * @return
	 */
	public static Integer getIntValue(Map map, String key,Integer expand){
		Integer value = getIntValue(map, key);
		if(null == value){
			return expand;
		}else{
			return value;
		}
	}
	
	/**
	 * 返回对象的int类型的值
	 * @param valueObj
	 * @return
	 */
	public static Integer getIntValue(Object valueObj){
		Integer value = null;
		if(valueObj instanceof Integer){
			value = (Integer) valueObj;
		}else if(valueObj instanceof String){
			try {
				Double dValue = Double.valueOf((String)valueObj);
				value = dValue.intValue();
			} catch (Exception e) {
				value = null;
			}
		}else if(valueObj instanceof Double){
			Double dValue = (Double) valueObj;
			value = dValue.intValue();
		}else if(valueObj instanceof Float){
			Float fValue = (Float) valueObj;
			value = fValue.intValue();
		}else if(valueObj instanceof Long){
			Long lValue = (Long) valueObj;
			lValue.intValue();
		}
		return value;
	}
	
	/**
	 * 返回容器中的key的double值
	 * @param map 容器
	 * @param key key
	 */
	public static Double getDoubleValue(Map map,String key){
		if(null == map || map.size() == 0 || !map.containsKey(key) 
				|| key == null || isTrimNull(key)){
			return null;
		}
		Object valueObj = map.get(key);
		Double value = getDoubleValue(valueObj);
		return value;
	}
	
	/**
	 * 返回容器中的key的double值，没有则返回期望值
	 * @param map 容器
	 * @param key key
	 * @param expand 期望值
	 */
	public static Double getDoubleValue(Map map,String key,Double expand){
		Double tmp = getDoubleValue(map,key);
		if(null == tmp){
			return expand;
		}else{
			return tmp;
		}
	}
	
	/**
	 * 返回对象的double值对象
	 * @param objValue 对象
	 */
	public static Double getDoubleValue(Object objValue){
		if(null == objValue){
			return null;
		}
		Double value = null;
		if(objValue instanceof Double){
			value = (Double) objValue;
		}else if(objValue instanceof String){
			String sValue = (String) objValue;
			try {
				value = Double.valueOf(sValue);
			} catch (Exception e) {
				value = null;
			}
		}else if(objValue instanceof Integer){
			Integer iValue = (Integer) objValue;
			value = iValue.doubleValue();
		}else if(objValue instanceof Float){
			Float fValue = (Float) objValue;
			value = fValue.doubleValue();
		}else if(objValue instanceof Long){
			Long lValue = (Long) objValue;
			lValue.doubleValue();
		}
		return value;
	}
	
	/**
	 * 返回容器的时间值 
	 *@param map 容器
	 *@param key key
	 * @throws ParseException 
	 */
	public static Date getDateValue(Map map, String key){
		return getDateValue(map, key,"yyyy-MM-dd HH:mm:ss");
	}
	public static Date getDateValue(String dateStr){
		return getDateValue(dateStr, "yyyy-MM-dd HH:mm:ss");
	}
	public static Date getDateValue(String dateStr, String format){
		if(null == dateStr || dateStr.trim().length() == 0)
			return null;
		return DateUtil.convert2Date(dateStr, format);
	}
	
	/**
	 * 返回容器的时间值 
	 *@param map 容器
	 *@param key key
	 *@param format 格式
	 * @throws ParseException 
	 */
	public static Date getDateValue(Map map, String key,String format){
		if(null == map || map.size() == 0 || !map.containsKey(key) 
				|| key == null || isTrimNull(key)){
			return null;
		}
		Date value = null;
		Object obj = map.get(key);
		if(null == obj)
			return null;
		
		if(obj instanceof Date){
			value = (Date) obj;
		}else if(obj instanceof String){
			String sValue = (String) obj;
			if(null == sValue || sValue.trim().length() == 0)
				return null;
			value = DateUtil.convert2Date(sValue, format);
		}
		return value;
	}
	
	/**
	 * 返回转换编码后的字符串
	 * @param source
	 * @param oldCode 旧编码，一般是ISO-8859-1
	 * @param newCode 新编码，ISO-8859-1、GBK、UTF-8
	 * @return
	 */
//	public static String changeCode(String source,String oldCode,String newCode){
//		if(null == source)
//			return null;
//		try {
//			String codeValue = "ISO-8859-1";
//			if("gbk".equalsIgnoreCase(oldCode)){
//				codeValue = "GBK";
//			}else if("utf8".equalsIgnoreCase(oldCode) || "utf-8".equalsIgnoreCase(oldCode)){
//				codeValue = "UTF-8";
//			}else if("ISO-8859-1".equalsIgnoreCase(oldCode)){
//				codeValue = "ISO-8859-1";
//			}
//			return new String(source.getBytes(codeValue),newCode);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	/**
	 * 将ISO-8859-1的字符串返回UTF-8的字符串
	 * @param source
	 * @return
	 */
//	public static String iSO88591ToUTF8Code(String source){
//		if(null == source)
//			return null;
//		try {
//			return new String(source.getBytes("ISO-8859-1"),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	/** 
     * 将emoji表情替换成空串
     * @param source 
     * @return 过滤后的字符串 
     */  
    public static String filterEmoji(String source) {  
        if(!CommonUtil.isTrimNull(source)){  
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");  
        }else{  
            return source;  
        }  
    }  
	
}
