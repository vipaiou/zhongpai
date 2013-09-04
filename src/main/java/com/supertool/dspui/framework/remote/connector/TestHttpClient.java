package com.supertool.dspui.framework.remote.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;


public class TestHttpClient {
    
    public static void simplePost(){
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "http://localhost:8080/testComponent/print?apiKey=bigbang&sign=yeath";
        HttpPost httpPost = new HttpPost(url);
        try{
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println(response.toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void postWithBody(){
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "http://localhost:8080/testComponent/print?apiKey=bigbang&sign=yeath";
        HttpPost httpPost = new HttpPost(url);
        try{
            StringEntity entity = new StringEntity("{\"good\":\"bad\"}", "UTF-8");
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println(response.toString());
            HttpEntity e = response.getEntity();
            StringBuilder ret = new StringBuilder();
            String line = "";
            if(e != null){
                InputStream is = e.getContent();
                // Wrap a BufferedReader around the InputStream
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // Read response until the end
                while ((line = rd.readLine()) != null) { 
                    ret.append(line); 
                }
            }
            System.out.println(ret);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void postWithRetry(){
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "http://192.168.3.5?apiKey=bigbang&sign=yeath";
        HttpPost httpPost = new HttpPost(url);
        try{
            StringEntity entity = new StringEntity("{\"good\":\"bad\"}", "UTF-8");
            httpPost.setEntity(entity);
            HttpRequestRetryHandler retryHandler = new 
            HttpRequestRetryHandler() {
                @Override
                public boolean retryRequest(IOException exception, int executionCount,
                        HttpContext httpContext) {
                    if (executionCount > 3){
                        System.out.println("Ha, three times!");
                        return false;
                    }
                    return false;
                }
            };
            httpClient.setHttpRequestRetryHandler(retryHandler);
            HttpParams params = httpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(params, 5000);
            HttpConnectionParams.setSoTimeout(params, 5000);
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println(response.toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        postWithBody();
    }
}