package com.supertool.dspui.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import com.supertool.dspui.vo.ResultVO;

public class ObjectValueUtil {

	public static ResultVO isHasNullValue (Class<?> cls){
		
		int flag = 1;
		String msg = "检查对象实例是否含有空属性值";
		if(null == cls){
			flag = 0;
			msg = "传入 class 为null!";		
		}
		else{
			Method[] methods = cls.getMethods();  
	        for (int i = 0; i < methods.length; i++) {  
	            Method method = methods[i];  
	            if (method.getName().startsWith("get") && !method.getName().equalsIgnoreCase("getClass")&&!method.getName().equalsIgnoreCase("getSerialversionuid") ) {  
	            	try {
						if(null ==method.invoke(cls.newInstance())){
							flag = 0;
							String fieldName = method.getName().substring(3);
							msg = fieldName +"为null";
							break;
						}
					} catch (IllegalArgumentException e) {
						flag = 0;
						msg = e.getMessage();
					} catch (IllegalAccessException e) {
						flag = 0;
						msg = e.getMessage();
					} catch (InvocationTargetException e) {
						flag = 0;
						msg = e.getMessage();
					} catch (InstantiationException e) {
						flag = 0;
						msg = e.getMessage();
					}
	            }
	        }
	        
	        flag = 1;
			msg = "所有属性值都不为null";

		}
		ResultVO vo = new ResultVO();
		vo.setResultCode(flag);
		vo.setMessage(msg);
		return vo;
	}
	public static List<String> getPropertyNames(Class<?> cls){
		if(null == cls){
			return null;
		}
		List<String> properties =new LinkedList<String>();
		Field[] fieldlist = cls.getDeclaredFields();
        for (int i = 0; i < fieldlist.length; i++) {
            Field fld = fieldlist[i];
            if(!fld.getName().equalsIgnoreCase("serialVersionUID")){
            	properties.add(fld.getName());
            }
            
         }
        return properties;
	}
}
