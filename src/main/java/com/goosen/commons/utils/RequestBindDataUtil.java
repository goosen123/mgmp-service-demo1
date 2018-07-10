package com.goosen.commons.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import com.goosen.commons.model.commons.http.ReqParams;


/**
 * 设置请求头的信息和参数到请求信息中
 * 2018-04-25 14:47:01
 * @author Goosen
 *
 */
public class RequestBindDataUtil {
	
	public static void bindDataToRequest(HttpEntityEnclosingRequestBase httpMethodEntity, ReqParams reqParams) throws UnsupportedEncodingException{
		if(null == reqParams)
			return;
		boolean sign = false;
		//设置请求头
		Map<String, String> headerMap = reqParams.getHeaderMap();
		if(null != headerMap && headerMap.size() > 0){
			for(String key : headerMap.keySet()){
				String value = headerMap.get(key);
				httpMethodEntity.addHeader(key, value);
//				if("Content-Type".equals(key)){
//					sign = true;
//				}
			}
		}
		
		String postText = reqParams.getPostText();
		if(postText != null){
			if(!sign){
				String type = "application/";
				String postType = reqParams.getPostType();
				if(null == postType || postType.trim().length() == 0){
					postType = "json";
				}
				type = type + postType;
//				httpMethodEntity.addHeader("Content-Type", type);
				sign = true;
			}
			//设置
			httpMethodEntity.setEntity(new StringEntity(postText, "UTF-8"));
			return;
		}
		
		Map<String, String>  paramsMap = reqParams.getParamsMap();
		if(null != paramsMap && paramsMap.size() > 0){
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			for(String key : paramsMap.keySet()){
				String value = paramsMap.get(key);
				params.add(new BasicNameValuePair(key,value));
			}
		
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
//			entity.setContentType("application/json");
			httpMethodEntity.setEntity(entity);
			if(!sign){
//				httpMethodEntity.addHeader("Content-Type", "application/json;charset=UTF-8");
				sign = true;
			}
			return;
		}
	}
	
	public static void bindDataToRequest(HttpRequestBase httpMethodEntity, ReqParams reqParams){
		if(null == reqParams)
			return;
		boolean sign = false;
		//设置请求头
		Map<String, String> headerMap = reqParams.getHeaderMap();
		if(null != headerMap && headerMap.size() > 0){
			for(String key : headerMap.keySet()){
				String value = headerMap.get(key);
				httpMethodEntity.addHeader(key, value);
				if("Content-Type".equals(key)){
					sign = true;
				}
			}
		}
	}
	

}
