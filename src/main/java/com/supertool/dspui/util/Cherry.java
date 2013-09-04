package com.supertool.dspui.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class Cherry {
    private static final Long ONE_DAY = 86400000L;
    private static final Long ONE_HOUR = 3600000L;

    public static String trim(String str,String ... character){
        if(null == str) return "";
        String c = " ";
        if(character != null && character.length >0){
            c = character[0];
        }
        String regx = "^" + c + "+|" + c +"+$";
        return str.replaceAll(regx,"");
    }
    
    public static String percent(double n) {
        NumberFormat f = NumberFormat.getPercentInstance(Locale.SIMPLIFIED_CHINESE);
        f.setRoundingMode(RoundingMode.HALF_UP);
        f.setMaximumFractionDigits(2);
        f.setMinimumFractionDigits(2);
        return f.format(n);
    }
    
    public static String percent(String str) {
        String s = filterChar(str,"[0-9.]");
        double d = Double.parseDouble(s) / 100;
        return percent(d);
    }
    
    public static int compareVersion(String v1,String v2){
        String regex = "[0-9.]";
        v1 = filterChar(v1,regex);
        v2 = filterChar(v2,regex);
        List<Integer> l1 = Lists.listInt(v1,"\\.");
        List<Integer> l2 = Lists.listInt(v2,"\\.");
        int minus = l1.size() - l2.size();
        if(minus > 0 ){
            for(int i = 0; i < minus; i++){
                l2.add(0);
            }
        }else{
            for(int i = 0; i < -minus; i++){
                l1.add(0);
            }
        }
        for(int i = 0; i < l1.size(); i++){
            int a = l1.get(i);
            int b = l2.get(i);
            if(a > b){
                return 1;
            }else if(a < b){
                return -1;
            }
        }
        return 0;
    }
    
    public static String maxVersion(List<String> list){
        String max = "";
        for(String str : list){
            if(compareVersion(str,max) > 0){
                max = str;
            }
        }
        return max;
    }
    
    public static String filterChar(String str,String regex){
        Pattern p = Pattern.compile(regex);
        String result = "";
        for(int i = 0; i < str.length(); i++){
            Character c = str.charAt(i);
            Matcher m = p.matcher(c+"");
            if(m.find()){
                result += c;
            }
        }
        return result;
    }
    
    public static boolean isDouble(String str){
        return Pattern.compile("^\\d+|\\d+.\\d+$").matcher(str).matches();
    }
    
    public static boolean isNumber(String str){
        return Pattern.compile("^\\d+$").matcher(str).matches();
    }
    
    public static boolean isPositiveNumber(String str){
        return Pattern.compile("^[1-9]+[0-9]*$").matcher(str).matches();
    }
    
    public static Double getDouble(String str,Double def){
        Double result;
        try{
            result = Double.parseDouble(str);
        }catch(Exception e){
            result = def;
        }
        return result;
    }
    
    public static Double check(Double d,Double def){
        if(null == d){
            return def;
        }
        return d;
    }
    
    public static <T> T check(T o,T def){
        if(null == o){
            return def;
        }
        return o;
    }
    
    public static Integer toInt(Object s,Integer def){
        Integer result;
        try{
            result = Integer.parseInt(s.toString());
        }catch(Exception e){
            result = def;
        }
        return result;
    }
    
    public static Long toLong(Object s,Long def){
        Long result;
        try{
            result = Long.parseLong(s.toString());
        }catch(Exception e){
            result = def;
        }
        return result;
    }
    
    public static String toStr(Object o,String def){
        if(null == o){
            return def;
        }
        return o.toString();
    }
    
    public static String listToStr(List l){
        String s = l.toString();
        s = s.substring(1,s.length()-1);
        return s;
    }
    
    public static String format(Double d){
        NumberFormat f = NumberFormat.getNumberInstance(Locale.SIMPLIFIED_CHINESE);
        f.setMaximumFractionDigits(2);
        f.setGroupingUsed(false);
        f.setRoundingMode(RoundingMode.HALF_UP);
        return f.format(d);
    }
    
    public static String format(Date date,String ...formatStr){
        try {
            if (formatStr == null || formatStr.length <= 0) {
                return new SimpleDateFormat("yyyy-MM-dd").format(date);
            } else {
                return new SimpleDateFormat(formatStr[0]).format(date);
            }
        } catch (Exception e) {
            return "";
        }
    }
    
    public static String formatMoney(Double d){
        NumberFormat f = NumberFormat.getNumberInstance(Locale.SIMPLIFIED_CHINESE);
        f.setMaximumFractionDigits(2);
        f.setMinimumFractionDigits(2);
        f.setGroupingUsed(false);
        f.setRoundingMode(RoundingMode.HALF_UP);
        return f.format(d);
    }
    
    public static boolean equals(Double a,Double b){
        if(a - b > 0.0000001){
            return false;
        }else{
            return true;
        }
    }
    
    public static boolean isBlank(Collection c){
        if(null == c || 0 == c.size()){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isBlank(JSONObject o){
        if(null == o || 0 == o.size()){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isBlank(String s){
        if(null == s || "".equals(s.trim())){
            return true;
        }else{
            return false;
        }
    }
    
    public static String getContentType(HttpServletRequest request){
        String contentType = Cherry.check(request.getContentType(),"");
        int semicolonIdx;
        if ((semicolonIdx = contentType.indexOf(";")) != -1){
            contentType = contentType.substring(0,semicolonIdx);
        }
        return contentType.trim();
    }
    
    public static Date add(Date date,int days){
        return new Date(date.getTime() + days * ONE_DAY);
    }
    
    public static Long diffHour(Date a,Date b){
        return (a.getTime() - b.getTime()) / ONE_HOUR;
    }
    
    public static HttpResponse post(String url, Map<String, Object> params){
        final Integer failedCount = 3;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (String key : params.keySet()) {
            String value = toStr(params.get(key),null);
            formparams.add(new BasicNameValuePair(key,value));
        }
        UrlEncodedFormEntity entity = null;
        try{
            entity = new UrlEncodedFormEntity(formparams, "UTF-8");
        }catch(UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }
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
        HttpResponse response = null;
        try{
            response = httpClient.execute(post);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return response;
    }
    
    public static String extractContent(HttpResponse response){
        if (null == response) {
            return "";
        }
        HttpEntity entity = response.getEntity();
        StringBuilder ret = new StringBuilder();
        String line = "";
        if (entity != null) {
            try{
                InputStream is = entity.getContent();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                while ((line = rd.readLine()) != null) {
                    ret.append(line);
                }
                EntityUtils.consume(entity);
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return StringEscapeUtils.unescapeJava(ret.toString());
    }
    
    public static String encodeURL(String str){
        try{
            return URLEncoder.encode(str, "UTF-8");
        }catch(UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) throws Exception{ 
        String url = "http://open.adx.qq.com/location/list";
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("dsp_id", "10011");
        params.put("token", "02bff6e29fe0dc2a5bd9dd93aee765a2");
        HttpResponse respose = post(url,params);
        System.out.println(extractContent(respose));
    }
}
