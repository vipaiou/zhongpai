package com.supertool.dspui.context;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import com.supertool.dspui.framework.MessageConverters;
import com.supertool.dspui.util.ParamsResolver;

//如果需要使用需要添加到context配置文件，让spring初始化时加载@PostConstruct方法
public class OnContextComplete {

	@Autowired
	private AnnotationMethodHandlerAdapter handlerAdapter;
	
	@Autowired
	private MessageConverters customMessageConverters;
	
	@Autowired
	private ParamsResolver paramsResolver;
	
	private void fixHttpMessageConverters() {
		HttpMessageConverter<?>[] converters = handlerAdapter.getMessageConverters();
	  	Map<String, HttpMessageConverter<?>> map = customMessageConverters.getMessageConverterMap();
	  	for (int i = 0; i < converters.length; ++i) {
	      	HttpMessageConverter<?> conv = converters[i];
	      	if (conv instanceof StringHttpMessageConverter) {
	         	converters[i] = map.get("string");
	       	}
	       	if (conv instanceof MappingJacksonHttpMessageConverter) {
	        	converters[i] = map.get("json");
	      	}
	  	}
	}

	private void registerCustomArgumentResolver() {
	  	handlerAdapter.setCustomArgumentResolvers(array(paramsResolver));
	}

    public static <E> E[] array(E... data) {
        return data;
    }
	
	@PostConstruct
	public void onContextComplete() {
		fixHttpMessageConverters();
		registerCustomArgumentResolver();
	}
}
