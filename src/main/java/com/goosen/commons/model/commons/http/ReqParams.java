package com.goosen.commons.model.commons.http;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * http请求参数信息
 * 2018-04-25 14:41:01
 * @author Goosen
 *
 */
public class ReqParams {

	/**请求头配置*/
	private Map<String,String> headerMap;
	
	/**请求参数*/
	private Map<String,String> paramsMap;
	
	/**post数据，优先级高于请求参数，如果存在，则忽略请求参数的值*/
	private String postText;
	
	/**json,xml*/
	private String postType;
	
	
	/**
	 * 添加请求头配置
	 */
	public void addHeader(String name, String value){
		if(null == headerMap)
			headerMap = new LinkedHashMap<String,String>();
		headerMap.put(name, value);
	}
	
	/**
	 * 移除对应请求头信息
	 */
	public void removeKeyHeader(String name){
		if(null == headerMap)
			return;
		if(headerMap.containsKey(name))
			headerMap.remove(name);
	}
	
	/**
	 * 添加请求参数
	 */
	public void addParams(String name, String value){
		if(null == paramsMap)
			paramsMap = new LinkedHashMap<String,String>();
		paramsMap.put(name, value);
	}
	
	
	/**
	 * 移除对应参数
	 */
	public void removeKeyParams(String name){
		if(null == paramsMap)
			return;
		if(paramsMap.containsKey(name))
			paramsMap.remove(name);
	}

	public Map<String, String> getHeaderMap() {
		return headerMap;
	}

	public void setHeaderMap(Map<String, String> headerMap) {
		this.headerMap = headerMap;
	}

	public Map<String, String> getParamsMap() {
		return paramsMap;
	}

	public void setParamsMap(Map<String, String> paramsMap) {
		this.paramsMap = paramsMap;
	}
	
	public String getPostText() {
		return postText;
	}

	/**
	 * post数据，优先级高于请求参数，如果存在，则忽略请求参数的值
	 */
	public void setPostText(String postText) {
		if(null == getPostType())
			setPostType("json");
		this.postText = postText;
	}

	public String getPostType() {
		return postType;
	}

	/**
	 * json xml
	 */
	public void setPostType(String postType) {
		this.postType = postType;
	}
	
	
}
