package com.supertool.dspui.util;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;

public class SpringMessageSource extends ResourceBundleMessageSource {  
    // ~ Constructors  
    // ===================================================================================================  
  
    public SpringMessageSource() {  
        setBasename("messages_zh");  
    }  
  
    // ~ Methods  
    // ========================================================================================================  
  
    public static MessageSourceAccessor getAccessor() {  
        return new MessageSourceAccessor(new SpringMessageSource());  
    }  
}  