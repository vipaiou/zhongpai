package com.supertool.dspui.framework.remote.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.supertool.dspui.config.DebugConfig;
import com.supertool.dspui.context.ConfigContext;
import com.supertool.dspui.exception.ApiAuthException;
import com.supertool.dspui.exception.BadRequestException;
import com.supertool.dspui.framework.remote.errors.HttpResponseException;
import com.supertool.dspui.framework.remote.errors.NotFoundException;

public class HttpConnector extends Connector {
    private Logger logger = Logger.getLogger(HttpConnector.class);
    private DefaultHttpClient httpClient;


    public HttpConnector() {
        ThreadSafeClientConnManager cm;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(
            new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        cm = new ThreadSafeClientConnManager(schemeRegistry);
        // Increase max total connection to 200
        cm.setMaxTotal(200);
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(20);

        httpClient = new DefaultHttpClient(cm);
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(DefaultHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public boolean send(final RemoteServer remoteServer, String key, String value) throws Exception {
        String url = remoteServer.getMethodUrls().get(key);
        String startInfo = "Start post to server: " + remoteServer.getServerName() + ", ip: "
            + remoteServer.getIp() + ", url:" + url;
        String endInfo = "End post to server: " + remoteServer.getServerName() + ", ip: "
            + remoteServer.getIp() + ", url:" + url;
        logger.info(startInfo);
        boolean ret = false;
        HttpResponse response = post(url, value, remoteServer.getFailedCount());
        ret = checkResponse(url, response);
        logger.info(endInfo);
        return ret;
    }

    public boolean send(final RemoteServer remoteServer, String key, String value, Map<String, Object> urlParams) throws Exception {
        String url = remoteServer.getMethodUrls().get(key);
        String startInfo = "Start post to server: " + remoteServer.getServerName() + ", ip: "
            + remoteServer.getIp() + ", url:" + url;
        String endInfo = "End post to server: " + remoteServer.getServerName() + ", ip: "
            + remoteServer.getIp() + ", url:" + url;
        logger.info(startInfo);
        boolean ret = false;
        HttpResponse response = post(url, value, remoteServer.getFailedCount(), urlParams);
        ret = checkResponse(url, response);
        logger.info(endInfo);
        return ret;
    }

    private HttpResponse post(String url, String value, final Integer failedCount, Map<String, Object> urlParams) throws Exception {
        url = URLUtil.make(url, urlParams);
        if (ConfigContext.get(DebugConfig.class).getIsShowPost()) {
            logger.info("[Post]: " + url);
            logger.debug("[Body]: " + value);
        }
        HttpPost httpPost = new HttpPost(url);
        if (failedCount > 0) {
            HttpRequestRetryHandler retryHandler = new
                HttpRequestRetryHandler() {
                    @Override
                    public boolean retryRequest(IOException exception, int executionCount,
                        HttpContext httpContext) {
                        if (executionCount > failedCount) {
                            return false;
                        }
                        return false;
                    }
                };
            httpClient.setHttpRequestRetryHandler(retryHandler);
        }
        StringEntity entity = new StringEntity(value, "utf-8");
        httpPost.setEntity(entity);
        // set time out
        HttpParams params = httpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 300000);
        HttpConnectionParams.setSoTimeout(params, 300000);
        HttpResponse response = httpClient.execute(httpPost);
        if (ConfigContext.get(DebugConfig.class).getIsShowPost()) {
            logger.info("End Posting (^_^)");
        }
        return response;
    }

    /**
     * 返回HttpResponse的post请求
     * 
     * @param url
     * @param failedCount
     *            重试次数
     * @param value
     *            需要post发送的信息
     * @return
     * @throws Exception
     */
    public HttpResponse post(String url, String value, final Integer failedCount) throws Exception {
        return post(url, value, failedCount, null);
    }

    /**
     * 处理API调用返回的状态码
     * 
     * @param response
     * @return
     * @throws Exception
     */
    public boolean checkResponse(String url, HttpResponse response) throws Exception {
        if (response != null) {
            String res = this.extractContent(response);
            if (ConfigContext.get(DebugConfig.class).getIsShowResponse()) {
                logger.debug("[Response]: " + res);
            }
            if (response.getStatusLine().getStatusCode() == 200) {
                return true;
            } else if (response.getStatusLine().getStatusCode() == 403) {
                throw new ApiAuthException(res);
            } else if (response.getStatusLine().getStatusCode() == 400) {
                throw new BadRequestException(res);
            } else if (response.getStatusLine().getStatusCode() == 404) {
                throw new NotFoundException(url);
            } else {
                throw new HttpResponseException(response.getStatusLine().getStatusCode(), res);
            }
        }
        return false;
    }

    /**
     * 从HttpResponse中获得错误信息
     * 
     * @param response
     * @return
     * @throws Exception
     */
    public String extractContent(HttpResponse response) throws Exception {
        if (null == response) {
            return "";
        }
        HttpEntity entity = response.getEntity();
        StringBuilder ret = new StringBuilder();
        String line = "";
        if (entity != null) {
            InputStream is = entity.getContent();
            // Wrap a BufferedReader around the InputStream
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, "utf-8"));
            // Read response until the end
            while ((line = rd.readLine()) != null) {
                ret.append(line);
            }
            EntityUtils.consume(entity);
        }
        return ret.toString();
    }

    public HttpResponse get(String url) throws Exception {
        return get(url, null);
    }

    public HttpResponse get(String url, Map<String, String> params) throws Exception {
        // set time out
        HttpParams httpParams = httpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
        HttpConnectionParams.setSoTimeout(httpParams, 5000);
        // set query params
        HttpGet get = null;
        if (null != params && params.size() > 0) {
            List<NameValuePair> qparams = new ArrayList<NameValuePair>();
            for (String key : params.keySet()) {
                qparams.add(new BasicNameValuePair(key, params.get(key)));
            }
            get = new HttpGet(url + "?" + URLEncodedUtils.format(qparams, "utf-8"));
        } else {
            get = new HttpGet(url);
        }
        // get
        return httpClient.execute(get);
    }

    public HttpResponse post(String url, Map<String, Object> params, final int failedCount) {
        HttpPost post = new HttpPost(url);
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (String key : params.keySet()) {
            formparams.add(new BasicNameValuePair(key, params.get(key).toString()));
        }
        UrlEncodedFormEntity entity;
        try {
            entity = new UrlEncodedFormEntity(formparams, "utf-8");
            post.setEntity(entity);
            if (failedCount > 0) {
                HttpRequestRetryHandler retryHandler = new
                    HttpRequestRetryHandler() {
                        @Override
                        public boolean retryRequest(IOException exception, int executionCount,
                            HttpContext httpContext) {
                            if (executionCount > failedCount) {
                                return false;
                            }
                            return false;
                        }
                    };
                httpClient.setHttpRequestRetryHandler(retryHandler);
            }
            // set time out
            HttpParams conParams = httpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(conParams, 5000);
            HttpConnectionParams.setSoTimeout(conParams, 600000);
            HttpResponse response = httpClient.execute(post);
            return response;
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
            return null;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (ConnectTimeoutException e) {
            logger.error(e.getMessage());
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String postJSON(String url, Map<String, Object> params, int failCnt) {
        try {
            HttpResponse resp = post(url, params, failCnt);
            String json = extractContent(resp);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } 
    }
    
    public String postJSON(String url, String params, int failCnt) {
        try {
            HttpResponse resp = post(url, params, failCnt);
            String json = extractContent(resp);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } 
    }

    public String getJSON(String url, Map<String, String> params, int failCnt) {
        try {
            HttpResponse resp = get(url, params);
            return extractContent(resp);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public void release() {
        httpClient.getConnectionManager().shutdown();
    }
}