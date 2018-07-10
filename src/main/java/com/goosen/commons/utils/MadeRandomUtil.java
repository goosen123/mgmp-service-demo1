package com.goosen.commons.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 随机值工具类
 * 2018-04-23 16:27:01
 * @author Goosen
 *
 */
public class MadeRandomUtil {
	
	/**
	 * 生产随机值
	 * @param count 随机值的个数
	 * @param letters 是否有字母，是true 
	 * @param numbers 是否有数字，是true
	 * @return
	 */
	public static String random(int count, boolean letters, boolean numbers){
		return RandomStringUtils.random(count, letters, numbers);
	}
	
}
