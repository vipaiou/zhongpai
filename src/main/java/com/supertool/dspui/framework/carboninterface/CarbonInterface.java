package com.supertool.dspui.framework.carboninterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.model.Rtb;
import com.supertool.dspui.util.StringUtil;

public class CarbonInterface {

	private static Logger logger = Logger.getLogger(CarbonInterface.class);
	private static MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
	private static HttpClient client = new HttpClient(connectionManager);
	
    private static String sendRequest(String url, String method, String body) {

        try {
            PostMethod postMethod = new PostMethod(url);
    		postMethod.setRequestHeader("Accept", "application/json");
    		postMethod.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            
            if(body != null && body.length() > 0){
            	String b = JSONObject.fromObject(body).toString();
            	postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            	postMethod.setRequestBody(b);
        	}
            int status = client.executeMethod(postMethod);
            System.out.println(status);
            if(200 == status || 400 == status){
                StringBuffer responseBuffer = new StringBuffer();
                String readLine;
                BufferedReader responseReader;
                responseReader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),
						postMethod.getResponseCharSet()));
                while ((readLine = responseReader.readLine()) != null) {
                    responseBuffer.append(readLine);
                }
                responseReader.close();
                String s = responseBuffer.toString();
                return s;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            logger.error("MalformedURLException");
            return "";
        } catch (ConnectException e) {
            e.printStackTrace();
            logger.error("ConnectException");
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("IOException");
            return "";
        } catch (Exception e) {
            logger.error("Exception");
            return "";
		}
        return "";
    }
	
    private static JSONObject getJsonResult(String url,String result){
    	if(result == null || result.isEmpty()){
    		JSONObject json = new JSONObject();
    		json.put("resultCode", "0");
    		json.put("message", "carbon返回空结果或捕获到异常");
    		return json;
    	}
    	try {
    		JSONObject jsn = JSONObject.fromObject(result);
    		JSONObject json = new JSONObject();
    		json.put("resultCode", "1");
    		json.put("result", jsn);
    		return json;
		} catch (Exception e) {
			//System.out.println("解析结果出错");
			logger.error("请求"+url+",解析结果出错");
			JSONObject json = new JSONObject();
    		json.put("resultCode", "-1");
    		json.put("message", "解析carbon返回结果出错");
    		return json;
		}
    }
    
    public static JSONObject requestCarbon(String url, String body){
    	String s = sendRequest(url, "POST", body);
    	JSONObject jsonObject = getJsonResult(url,s);
    	logger.debug("请求"+url+"结果"+jsonObject);
    	return jsonObject;
    }
    
	public static void main(String[] args) {
		String url = "http://123.103.21.19:8080/carbon/adplacement/list" ;
		requestCarbon(url, null);
//		String s = sendRequest(url, "POST",null);
//		System.out.println(s);
//		
//		JSONObject jo = getJsonResult(url,s);
//		System.out.println(jo);
	}

}
