package com.supertool.dspui.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpFileUpload {

	private static Logger logger = Logger.getLogger(HttpFileUpload.class);

	public JSONObject upload(String url, File file, Map<String, Object> params) {
		Charset defaultCharset = Charset.forName("UTF-8");
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = null;
		HttpPost post = new HttpPost(url);
		try {
			MultipartEntity reqEntity = new MultipartEntity(
					HttpMultipartMode.STRICT, "multipart/form-data",
					defaultCharset);
			if (null != params) {
				Set<String> keySet = params.keySet();
				for (String key : keySet) {
					StringBody stringBody = new StringBody(params.get(key)
							.toString());
					reqEntity.addPart(key, stringBody);
				}
			}
			FileBody fileBody = new FileBody(file);
			reqEntity.addPart("file", fileBody);
			post.setEntity(reqEntity);
			response = httpClient.execute(post);
			HttpEntity resEntity = response.getEntity();
			String result = EntityUtils.toString(resEntity);
			EntityUtils.consume(resEntity);
			JSONObject jSONObject = JSONObject.fromObject(result);
			return jSONObject;
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return null;
	}
}
