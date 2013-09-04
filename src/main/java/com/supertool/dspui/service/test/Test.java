package com.supertool.dspui.service.test;

import java.io.UnsupportedEncodingException;
  
public class Test {      
     
	public static void main(String[] args) {
		String s="你号啊";
		System.out.println(s);
		String b;
		try {
			b = new String(s.getBytes("gbk"), "gbk");
			System.out.println(b);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
