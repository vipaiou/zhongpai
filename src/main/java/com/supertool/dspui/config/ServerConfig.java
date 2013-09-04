package com.supertool.dspui.config;

import java.util.List;
import java.util.Map;


public class ServerConfig {

	//外部服务器调用Carbon接口时使用的apiKey和apiSecret
	private String apiKey;
	private String apiSecret;
	//调用外部服务器接口时使用的apiKey和apiSecret
	private String key;
	private String Secret;
    private List<String> ips;
    private Integer port;
    private Integer failedCount;
    private String serverProtocol;
    private Map<String, String> methodUrls;
    

    public List<String> getIps() {
        return ips;
    }

    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSecret() {
		return Secret;
	}

	public void setSecret(String Secret) {
		this.Secret = Secret;
	}

	public Map<String, String> getMethodUrls() {
		return methodUrls;
	}

	public void setMethodUrls(Map<String, String> methodUrls) {
		this.methodUrls = methodUrls;
	}

	public String getServerProtocol() {
        return serverProtocol;
    }

    public void setServerProtocol(String serverProtocol) {
        this.serverProtocol = serverProtocol;
    }

    @Override
    public String toString() {
        return "Server [ips=" + ips + ", port=" + port + ", failedCount=" + failedCount + "]";
    }
}
