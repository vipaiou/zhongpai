package com.supertool.dspui.framework.remote.connector;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.http.protocol.HTTP;

/**
 * TODO: 移植到centron-web中
 * 
 * @author supertool
 * 
 */
public class URLUtil {
    private static String encode(final String content, final String encoding) {
        try {
            return URLEncoder.encode(content,
                encoding != null ? encoding : HTTP.DEFAULT_CONTENT_CHARSET);
        } catch (UnsupportedEncodingException problem) {
            throw new IllegalArgumentException(problem);
        }
    }

    public static Map<String, String> encodeParams(Map<String, Object> params, String encoding) {
        if (null == params) {
            return null;
        }
        Map<String, String> map = new HashedMap();
        for (String key : params.keySet()) {
            final String encodedKey = encode(key, encoding);
            final String value = params.get(key).toString();
            final String encodedValue = value != null ? encode(value, encoding) : "";
            map.put(encodedKey, encodedValue);
        }
        return map;
    }

    /**
     * 组装URL，注意，请保证url已经编码过
     * 
     * @param url
     *            已编码的URL
     * @param params
     *            未编码的参数
     * @param enc
     *            编码
     * @return
     * @throws MalformedURLException
     */
    public static String make(String url, Map<String, Object> params) throws MalformedURLException {
        return make(url, params, "utf-8");
    }

    /**
     * 组装URL，注意，请保证url已经编码过
     * 
     * @param url
     *            已编码的URL
     * @param params
     *            未编码的参数
     * @param enc
     *            编码
     * @return
     * @throws MalformedURLException
     */
    public static String make(String url, Map<String, Object> params, String enc) throws MalformedURLException {
        return concat(url, encodeParams(params, enc));
    }

    /**
     * 注意：这个函数不做Encode处理，请保证传入的url和urlParams是事先encode过的
     * 
     * @param url
     * @param urlParams
     * @return
     * @throws MalformedURLException
     */
    private static String concat(String url, Map<String, String> urlParams) throws MalformedURLException {
        if (urlParams.isEmpty()) {
            return url;
        }
        URL u = new URL(url);
        String ref = u.getRef();
        if (null == ref) {
            ref = "";
        } else {
            ref = "#" + ref;
        }
        String query = u.getQuery();
//        Map<String, String> params = Maps.parse(query, "=", "&");
//        for (String key : urlParams.keySet()) {
//            String value = urlParams.get(key);
//            params.put(key, value);
//        }
//        query = Centron.cmap(params).join("&", "=");
        if (!"".equals(query)) {
            query = "?" + query;
        }
        String path = u.getPath();
        /**
         * if (!path.endsWith("/")) { path = path + "/"; }
         **/
        URL u1 = new URL(u.getProtocol(), u.getHost(), u.getPort(), path + query + ref);
        return u1.toString();
    }

    public static void main(String[] args) throws MalformedURLException {
        Map<String, Object> params = new HashedMap();
        params.put("a", "%E4%BD%A0你");
        System.out.println(make("http://a.com/?a=10#sdf", params));
        System.out.println(make("http://a.com/?a=10#sdf", null));
        System.out.println(make("http://123.103.19.69:60091/url_whitelist", null));
        System.out.println(make("http://123.103.19.69:60091/url_whitelist", params));
    }
}
