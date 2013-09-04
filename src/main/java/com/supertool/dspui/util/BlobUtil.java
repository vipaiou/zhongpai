package com.supertool.dspui.util;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Map;

public class BlobUtil {

	public String getStringFromBlog(Map<String, Object> o) {
		Blob blob = (Blob) o.get("content");
		InputStream instream;
		try {
			instream = blob.getBinaryStream();
			int flength = (int) blob.length();
			byte[] b = new byte[flength];
			byte[] nb = new byte[1024];
			int len = 0;
			int tlen = 0;
			while (flength > 0) {
				len = instream.read(nb);
				System.arraycopy(nb, 0, b, tlen, len);
				tlen += len;
				flength -= len;
			}
			instream.close();
			return new String(b, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
