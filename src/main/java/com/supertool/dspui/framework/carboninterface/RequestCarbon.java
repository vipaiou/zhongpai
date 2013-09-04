package com.supertool.dspui.framework.carboninterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

public class RequestCarbon {
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
}
