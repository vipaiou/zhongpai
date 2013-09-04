package com.supertool.dspui.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.crypto.IllegalBlockSizeException;

public class SHAEncrypter {
   
private static SHAEncrypter _instance = new SHAEncrypter();
	
	public static SHAEncrypter getInstance() {
		return _instance;
	}
	
//	public static synchronized SHAEncrypter getInstance() {
//		if (_instance == null)
//			_instance = new AUserDAO();
//		return _instance;
//	}
	
    private SHAEncrypter() {
     }

    /**
	 * MD5����
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */ 
    public byte[] encryptSHA(byte[] data) throws Exception {  
     
        MessageDigest sha = MessageDigest.getInstance("SHA");  
        sha.update(data);  
     
        return sha.digest();  
     
    }  
    public String encrypt(String str) {
        try {
            // Encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes("UTF8");

            // Encrypt
            byte[] enc = encryptSHA(utf8);
            // Encode bytes to base64 to get a string
            BigInteger sha = new BigInteger(enc);   
            return sha.toString(32);
//            return new sun.misc.BASE64Encoder().encode(enc);
        } catch (javax.crypto.BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (java.io.IOException e) {
        } catch (Exception e){
        	
        }
        return null;
    }
}
