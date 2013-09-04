package com.supertool.dspui.framework.remote;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.supertool.dspui.context.ConfigContext;
import com.supertool.dspui.param.form.AccessUserForm;
import com.supertool.dspui.framework.remote.connector.HttpConnector;

/**
 * 连接Access登录的客户端
 * 
 */
@Service
public class AccessClient {

    private static Logger logger = LoggerFactory.getLogger(AccessClient.class);

    public AccessClient() {

    }

    public JSONObject getUserInfo(String userName) {
//        String url = ConfigContext.get(AccessConfig.class).getLoginUrl();
//        String productId = ConfigContext.get(AccessConfig.class).getProductId();
////        Integer failedCount = ConfigContext.get(AccessConfig.class).getFailedCount();
//        Map<String, String> params = new HashMap<String, String>();
//	     params.put("method", "getUserInfo");
//	     params.put("username", userName);
//	     params.put("productId", productId);
//	     params.put("userkey", "");
//	    HttpConnector hc = new HttpConnector();
//        String json = hc.getJSON(url, params, failedCount);
//        hc.release();
//        if (!StringUtils.isEmpty(json)) {
//        	JSONObject form = JSONObject.fromObject(json);
//            return form;
//        } else {
//            return null;
//        }
    	return null;
    }

    public JSONObject login(String userName, String password) {
//		 String url = ConfigContext.get(AccessConfig.class).getLoginUrl();
//	     String productId = ConfigContext.get(AccessConfig.class).getProductId();
//	     Integer failedCount = ConfigContext.get(AccessConfig.class).getFailedCount();
//	     Map<String, String> params = new HashMap<String, String>();
//	     params.put("method", "getUserPermission");
//	     params.put("username", userName);
//	     params.put("password", password);
//	     params.put("productId", productId);
//	     params.put("userkey", "");
//	     HttpConnector hc = new HttpConnector();
//	     String json = hc.getJSON(url, params, failedCount);
//	     hc.release();
//	     if (!StringUtils.isEmpty(json)) {
//            JSONObject form = JSONObject.fromObject(json);
//            return form;
//	     } else {
//            return null;
//	     }
    	return null;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        AccessClient.logger = logger;
    }

}
