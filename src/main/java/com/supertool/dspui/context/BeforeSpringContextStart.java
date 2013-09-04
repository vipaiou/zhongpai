package com.supertool.dspui.context;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.config.DebugConfig;
import com.supertool.dspui.config.ServerConfig;

/**
 * Spring没有提供事件机制可以在ApplicationContext开始之前调用代码，
 * 因此我们用一个bean来模拟这个事件，
 * 注意需要在xml配置里声明这个bean
 *
 */
public class BeforeSpringContextStart {

    public BeforeSpringContextStart() {
        init();
    }

    public void init() {
        registerConfigs();
    }

    private void registerConfigs() {
        ConfigContext.registerConfigType("server", ServerConfig.class);
        ConfigContext.registerConfigType("debug", DebugConfig.class);
        ConfigContext.registerConfigType("config", Config.class);
    }

    
}
