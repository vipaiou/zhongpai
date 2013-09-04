package com.supertool.dspui.security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.crypto.IllegalBlockSizeException;

import org.springframework.security.authentication.encoding.PasswordEncoder;

public class SecPassworsdEncoder implements PasswordEncoder {

	@Override
	public String encodePassword(String arg0, Object arg1) {
		 try {
	            // Encode the string into bytes using utf-8
	            byte[] utf8 = arg0.getBytes("UTF8");

	            // Encrypt
	            byte[] enc = encryptSHA(utf8);
	            // Encode bytes to base64 to get a string
	            BigInteger sha = new BigInteger(enc);   
	            return sha.toString(32);
//	            return new sun.misc.BASE64Encoder().encode(enc);
	        } catch (javax.crypto.BadPaddingException e) {
	        } catch (IllegalBlockSizeException e) {
	        } catch (UnsupportedEncodingException e) {
	        } catch (java.io.IOException e) {
	        } catch (Exception e){
	        	
	        }
	        return null;
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		  final String pass1 = "" + encPass;
	      final String pass2 = encodePassword(rawPass, salt);
	      final boolean result = pass1.equals(pass2);
	      return result;

	}
	 public byte[] encryptSHA(byte[] data) throws Exception {  
	     
	        MessageDigest sha = MessageDigest.getInstance("SHA");  
	        sha.update(data);  
	     
	        return sha.digest();  
	     
	} 
}
