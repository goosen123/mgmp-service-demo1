package com.goosen.commons.utils;

import java.util.UUID;

public class IdGenUtil {

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public synchronized static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
