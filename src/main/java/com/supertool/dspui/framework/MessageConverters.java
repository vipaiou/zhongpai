package com.supertool.dspui.framework;

import java.util.Map;

import org.springframework.http.converter.HttpMessageConverter;

public class MessageConverters {

    private Map<String, HttpMessageConverter<?>> messageConverterMap;
    private HttpMessageConverter<?>[] messageConverters;

    public HttpMessageConverter<?>[] getMessageConverters() {
        return messageConverters;
    }

    public void setMessageConverters(HttpMessageConverter<?>[] messageConverters) {
        this.messageConverters = messageConverters;
    }

    public Map<String, HttpMessageConverter<?>> getMessageConverterMap() {
        return messageConverterMap;
    }

    public void setMessageConverterMap(Map<String, HttpMessageConverter<?>> messageConverterMap) {
        this.messageConverterMap = messageConverterMap;
    }

}
