package com.supertool.dspui.util;


public class ParamValidateUtils {
	/**
	 * 验证密码输入是否合法,验证规则:不能包含特殊字符,比如:&,|,%,密码不得少于6个字符,
	 * @param password	密码
	 * @return	true表示密码输入正确,false表示用户名输入不正确
	 */
	public static boolean checkPassword(String password){
		if(password==null || password.length()<6){
			return false;
		}
		return true;
	}
	
	public static boolean checkRepeatPassword(String password, String repeatPassword){
		
		return password!=null && repeatPassword!=null && password.equals(repeatPassword);
	}
	
	public static boolean validateNotEmpty(String value){
		if(null == value){
			return false;
		}
		if("".equals(value)){
			return false;
		}
		return true;
	}
	
	public static boolean validateMaxLength(String value, int length){
		if(null == value){
			return true;
		}
		if(length < value.length()){
			return false;
		}
		return true;
	}
	
	public static boolean validateMatchRegexp(String value, String regexp){
		if(null == value || null == regexp){
			return true;
		}
		if(value.matches(regexp)){
			return true;
		}
		return false;
	}
	
	public static boolean validateExpected(String value, Object[] collection){
		if(null == value){
			return true;
		}
		for(Object item:collection){
			if(item.equals(value)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean validateDigits(String value){
		return null == value || "".equals(value) || validateMatchRegexp(value, "^\\d+$");
	}
	
	public static boolean validateNumber(String value){
		return null == value || validateMatchRegexp(value, "^-?(?:\\d+|\\d{1,3}(?:,\\d{3})+)(?:\\.\\d+)?$");
	}
}
