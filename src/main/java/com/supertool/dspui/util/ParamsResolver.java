package com.supertool.dspui.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public class ParamsResolver implements WebArgumentResolver {

//	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest)
			throws Exception {
		Class<?> pType = methodParameter.getParameterType();
        if (Map.class.equals(pType)) {
            HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
            @SuppressWarnings("unchecked")
			Map<String, String[]> params = request.getParameterMap();
			Map<String, Object> p = new HashMap<String, Object>();
            for (String key : params.keySet()) {
                String[] vs = params.get(key);
                if (key.endsWith("[]")) {
                    key = key.substring(0, key.indexOf("[]"));
                    p.put(key, vs);
                } else if (vs.length == 1) {
                    p.put(key, vs[0]);
                }
            }
            return p;
        }
        return UNRESOLVED;
	}
}
