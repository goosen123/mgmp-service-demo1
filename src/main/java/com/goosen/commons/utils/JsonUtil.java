package com.goosen.commons.utils;

import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * Json工具类
 * 2018-04-23 17:08:01
 * @author Goosen
 */
public class JsonUtil {
	
	/**
	 * 把对象转化成Json
	 * @param object：Bean、Map、List等
	 * @return
	 */
	public static String toJSONString(Object object){
		return JSON.toJSONString(object);
	}
	
	/**
	 * 把Json转化成对象
	 * @param text
	 * @param clazz：Bean、Map、List等
	 * @return
	 */
	public static <T> T parseObject(String text, Class<T> clazz){
		return JSON.parseObject(text, clazz);
	}
	
}
