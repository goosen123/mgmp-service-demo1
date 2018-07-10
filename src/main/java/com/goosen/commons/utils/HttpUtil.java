package com.goosen.commons.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.goosen.commons.model.commons.http.HTTPMethod;
import com.goosen.commons.model.commons.http.ReqParams;



/**
 * http工具类
 * 2018-04-25 14:13:01
 * @author Goosen
 *
 */
public class HttpUtil {

	
	/**
	 * 发送http请求
	 * @param
	 * 		 url:请求地址
	 * @param
	 * 		 reqParams ： 请求参数信息
	 * @param
	 *       method ： POST, GET ...
	 */
	public static String sendHTTPRequest(String url, ReqParams reqParams, String method) {

		HttpClient httpClient = getClient(url.startsWith("https") ? true : false);
		 
		String responseContent = null;
		try {

			HttpResponse response = null;

			if (method.equals(HTTPMethod.METHOD_POST)) {
				HttpPost httpPost = new HttpPost(url);

				RequestBindDataUtil.bindDataToRequest(httpPost, reqParams);

				response = httpClient.execute(httpPost);
			} else if (method.equals(HTTPMethod.METHOD_PUT)) {
				HttpPut httpPut = new HttpPut(url);
				
				RequestBindDataUtil.bindDataToRequest(httpPut, reqParams);

				response = httpClient.execute(httpPut);
			} else if (method.equals(HTTPMethod.METHOD_GET)) {

				HttpGet httpGet = new HttpGet(url);

				RequestBindDataUtil.bindDataToRequest(httpGet, reqParams);
				
				response = httpClient.execute(httpGet);

			} else if (method.equals(HTTPMethod.METHOD_DELETE)) {
				HttpDelete httpDelete = new HttpDelete(url);

				RequestBindDataUtil.bindDataToRequest(httpDelete, reqParams);
				response = httpClient.execute(httpDelete);
			}

			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				HttpEntity entity = response.getEntity();
				if (null != entity) {
					responseContent = EntityUtils.toString(entity, "UTF-8");
					EntityUtils.consume(entity);
				}
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}

		return responseContent;
	}

	/**
	 * Create a httpClient instance
	 * 
	 * @param isSSL
	 * @return HttpClient instance
	 */
	public static HttpClient getClient(boolean isSSL) {
		HttpClient httpClient = new DefaultHttpClient();
		if (isSSL) {
			X509TrustManager xtm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};

			try {
				SSLContext ctx = SSLContext.getInstance("TLS");

				ctx.init(null, new TrustManager[] { xtm }, null);

				SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);

				httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));

			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		return httpClient;
	}


}