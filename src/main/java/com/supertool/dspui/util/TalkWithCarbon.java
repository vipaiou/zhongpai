package com.supertool.dspui.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import com.supertool.dspui.context.UserContext;

public class TalkWithCarbon {
	/*
	 * 请求服务器地址
	 */
	private  String url;
	/*
	 * 请求方式
	 */
	private  String requestMethod;
	/*
	 * 是否传递参数
	 */
	private boolean isHasParams;
	/*
	 * 参数
	 */
	private  String params;
	/*
	 * 连接超时时间
	 */
	private Integer connectTimeout;
	/*
	 *  读取超时时间
	 */
	private Integer readTimeOut;
	
	private final  String POST_METHOD = "POST";
	private final  String Get_METHOD = "GET";

	private static MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
	private static HttpClient client = new HttpClient(connectionManager);
	private static Logger logger =Logger.getLogger(TalkWithCarbon.class);
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	
	
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public Integer getConnectTimeout() {
		return connectTimeout;
	}
	public void setConnectTimeout(Integer connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	public Integer getReadTimeOut() {
		return readTimeOut;
	}
	public void setReadTimeOut(Integer readTimeOut) {
		this.readTimeOut = readTimeOut;
	}
	public String getPOST_METHOD() {
		return POST_METHOD;
	}
	public String getGet_METHOD() {
		return Get_METHOD;
	}
	public boolean isHasParams() {
		return isHasParams;
	}
	public void setHasParams(boolean isHasParams) {
		this.isHasParams = isHasParams;
	}
	
	
	
	
	 public TalkWithCarbon() {
		super();
		this.connectTimeout = 0;
		this.readTimeOut = 0;
		this.isHasParams = false;
		
	}
	/**
     * 通过HttpURLConnection模拟post表单提交
     * 
     * @param path
     * @param params 例如"name=zhangsan&age=21"
     * @return
     * @throws Exception
     */
    public  String sendPostRequest() throws Exception{
    	
        URL requestUrl = new URL(getUrl());
        HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
        conn.setRequestMethod(getPOST_METHOD());// 提交模式
        conn.setConnectTimeout(getConnectTimeout());//连接超时 单位毫秒
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setReadTimeout(getReadTimeOut());//读取超时 单位毫秒
        if(isHasParams())
        {
        	 conn.setDoOutput(isHasParams());// 是否输入参数
             byte[] bypes = getParams().toString().getBytes();
             conn.getOutputStream().write(bypes);// 输入参数
        }
       
        InputStream inStream=conn.getInputStream();
        return readInputStream(inStream);
    }
    /**
     * 从输入流中读取数据
     * @param inStream
     * @return
     * @throws Exception
     */
    public  String readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len = inStream.read(buffer)) !=-1 ){
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();//网页的二进制数据
        outStream.close();
        inStream.close();
        String str =  new String(data, "UTF-8");
        return str;
    }
    /**
	 * 
	 * @param paramsMap 方法参数
	 * @param url 调用方法的地址
	 * @return JSONObject
	 */
	@SuppressWarnings("deprecation")
	public  JSONObject getCarbonVOJson (Map<String,Object> params,String url){

		PostMethod postMethod = new PostMethod(url);
		
		int dspId = UserContext.getDspId();
		params.put("dspId", dspId);
		
		postMethod.setRequestHeader("Accept", "application/json");
		postMethod.setRequestHeader("Content-Type", "application/json");
		
		
		
		//参数json化
		String paramsStr =JSONUtils.mapToJsonString(params);
		//设置参数
		postMethod.setRequestBody(paramsStr);
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");  
		BufferedReader br = null;
		try {
			
			int statusCode = client.executeMethod(postMethod);
			
				br = new BufferedReader(
						new InputStreamReader(postMethod.getResponseBodyAsStream(),
								postMethod.getResponseCharSet()));
				StringBuilder resBuilder = new StringBuilder();
				String resTemp = "";
				while ((resTemp = br.readLine()) != null) {
					resBuilder.append(resTemp);
				}
				JSONObject jSONObject = null ;
				String carbonResult = "";
				if(null != resBuilder && StringUtil.isNotBlank(resBuilder.toString())){
					carbonResult = resBuilder.toString();
					jSONObject = JSONObject.fromObject(carbonResult);
				}			
				return jSONObject;
				
		
		} catch (HttpException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			postMethod.releaseConnection();
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		return null;
	}
	
}
