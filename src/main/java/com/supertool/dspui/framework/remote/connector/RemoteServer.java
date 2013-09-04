package com.supertool.dspui.framework.remote.connector;

import java.util.HashMap;
import java.util.Map;

import com.supertool.dspui.config.ServerConfig;



public class RemoteServer {
	
	private String serverName;
	private String ip;
	private Integer port;
	//此map中的url是完整的url
	private Map<String, String> methodUrls = new HashMap<String, String>();
	private String apiKey;
	private String apiSecret;
	private Integer failedCount;
	private String serverProtocol;
	
	public RemoteServer(){}
	
	public RemoteServer(String serverName, String ip, Integer port, Map<String, String> methodUrls, String apiKey, String apiSecret, Integer failedCount, String serverProtocol){
		this.serverName = serverName;
		this.ip = ip;
		this.port = port;
		this.methodUrls = methodUrls;
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.failedCount = failedCount;
		this.serverProtocol = serverProtocol;
	}
	
	public static RemoteServer getRemoteServer(String serverName, String ip, Integer port, ServerConfig serverConfig){
        Map<String, String> mUrls = new HashMap<String, String>();
        if ("redis".equals(serverConfig.getServerProtocol())) {
            mUrls = serverConfig.getMethodUrls();
        } else {
            for (String m : serverConfig.getMethodUrls().keySet()) {
                StringBuffer sb = new StringBuffer();
                sb.append("http://").append(ip).append(":").append(port).append(serverConfig.getMethodUrls().get(m));
                mUrls.put(m, sb.toString());
            }
	    }
		return new RemoteServer(serverName, ip, port, mUrls, serverConfig.getKey(), serverConfig.getSecret(), serverConfig.getFailedCount(), serverConfig.getServerProtocol());
	}
	
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Map<String, String> getMethodUrls() {
		return methodUrls;
	}
	public void setMethodUrls(Map<String, String> methodUrls) {
		this.methodUrls = methodUrls;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getApiSecret() {
		return apiSecret;
	}
	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

	public Integer getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(Integer failedCount) {
		this.failedCount = failedCount;
	}

    public String getServerProtocol() {
        return serverProtocol;
    }

    public void setServerProtocol(String serverProtocol) {
        this.serverProtocol = serverProtocol;
    }

    @Override
    public String toString() {
        return "Server [" + serverName + ", " + ip + ":" + port + "]";
    }
}