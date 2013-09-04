package com.supertool.dspui.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionHandler implements HandlerExceptionResolver {  
	private static Logger logger = Logger.getLogger(CustomExceptionHandler.class);
    @Override  
    public ModelAndView resolveException(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception exception) {  
    	 logger.error("Catch Exception: ",exception);//把漏网的异常信息记入日志  
         Map<String,Object> map = new HashMap<String,Object>();  
       /*  StringPrintWriter strintPrintWriter = new StringPrintWriter();  
         exception.printStackTrace(strintPrintWriter);  
         System.out.println("CustomExceptionHandler:"+exception+"---");*/ 
         map.put("ex", exception);//将错误信息传递给view
         
         return new ModelAndView("exception",map);  
    }  
} 
