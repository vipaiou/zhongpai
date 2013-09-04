package com.supertool.dspui.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUpload {
static String boundary = "--------------7d226f700d0";
static String prefix = "--";
static String newLine = "\r\n";
public static void main(String args[]) {
	File file = new File("E://test_2012_05_22.png");
	try {
		InputStream in = new FileInputStream(file);
		upload("http://123.103.21.19:8080/carbon/material/upload", "test_2012_05_22.png", in);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void upload(String remoteUrl,String fileName , InputStream in) {
try {
URL url = new URL(remoteUrl);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setDoInput(true);
connection.setDoOutput(true);
//设定HTTP协议头
connection.setRequestProperty("Content-type","multipart/form-data;boundary="+boundary); 
AssemblyHttp(connection.getOutputStream(),fileName,in);
InputStream ins = connection.getInputStream();
byte[] b = readBuffer(ins);
System.out.println(new String(b));
} catch (MalformedURLException e) {
System.out.println(" URL 地址解析错误 ");
} catch (IOException e) {
System.out.println(" URL连接打开错误 ");
}
}
public static void AssemblyHttp(OutputStream out,String fileName, InputStream in) {
StringBuffer params = new StringBuffer();
 //编写分隔符
/*params.append(prefix + boundary + newLine);
 //键值说明
params.append("Content-Disposition: form-data; name=\"username\"");
 //如果内容不是文件,不用申明文件类型
params.append(newLine+newLine);
 //内容
params.append("bcpmai");
params.append(newLine);*/
 //第二条数据 分隔符
params.append(prefix + boundary + newLine);
 //键值说明
params.append("Content-Disposition: form-data; name=\"file\"; filename=\""+fileName+"\"");
params.append(newLine);
 //键值类型
params.append("Content-Type: image/png");
params.append(newLine+newLine);
try {

out.write(params.toString().getBytes());
 //第二条数据内容
out.write(readBuffer(in));
out.write(newLine.getBytes());
 //协议内容结尾
out.write((prefix + boundary + prefix + newLine).getBytes());
out.flush();
out.close(); 
} catch (FileNotFoundException e) {
System.out.println(" 没有找到文件 ");
} catch (IOException e) {
System.out.println(" 文件IO错误 ");
}
}
public static byte[] readBuffer(InputStream ins) throws IOException {
byte b[] = new byte[1024];
ByteArrayOutputStream stream = new ByteArrayOutputStream();
int len = 0;
while((len=ins.read(b))!= -1) {
stream.write(b, 0, len);
}
return stream.toByteArray();
}
}

