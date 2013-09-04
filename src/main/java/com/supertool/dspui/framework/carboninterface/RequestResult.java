package com.supertool.dspui.framework.carboninterface;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

public class RequestResult {
	private static Logger logger = Logger.getLogger(RequestResult.class);
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
	    
}
