package com.supertool.dspui.context;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import com.google.common.base.Strings;
import com.supertool.dspui.config.YamlConfig;

//如果需要使用需要添加到context配置文件，让spring初始化时加载@PostConstruct方法
public class ConfigContext {

    private static Logger logger = LoggerFactory.getLogger(ConfigContext.class);
    private static Map<String, Resource> _resources;
    private Map<String, Resource> resources;
    private static Map<String, Class<?>> configTypes = new HashMap<String, Class<?>>();
    private static final Map<Class<?>, Object> configs = new HashMap<Class<?>, Object>();
    private Resource root;
    private static Resource _root;

    public ConfigContext() {
        //registerConfigType("access", AccessConfig.class);
    }

    @PostConstruct
    public void init() {
        _resources = resources;//来自context-config.xml
        _root = root;//来自context-config.xml
        // 读取配置，因为各种配置类型已经在static函数registerConfigType里定义了，因此我们可以在这里读取出来
        try {
            loadConfig();
        } catch (Exception e) {
            logger.error("[ConfigContext] Error reading config files!!!! Exiting System", e);
            System.exit(-1);
        }
    }

    public static void loadConfig() {
        for (String name : configTypes.keySet()) {
            Class<?> type = configTypes.get(name);
            Resource r = _resources.get(name);
            String path = "";
            try {
                if (null == r) {
                    path = attemptPath(type);
                } else {
                    path = r.getFile().getAbsolutePath();
                }
                Object cfg = readConfig(type, path);
                configs.put(type, cfg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String attemptPath(Class<?> type) throws IOException {
        String rootPath = _root.getFile().getAbsolutePath();
        String configName = type.getSimpleName().replace("Config", "").toLowerCase();
        return FilenameUtils.concat(rootPath, configName + ".yml");
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> configType) {
        return (T) (configs.get(configType));
    }

    public static void registerConfigType(String configName, Class<?> configType) {
        configTypes.put(configName, configType);
    }

    public static <T> T readConfig(Class<T> configType, String path) {
        try {
            if (configType == null) {
                logger.error("[ConfigContext] ConfigType is not registered :" + path);
            }
            T cfg = YamlConfig.load(path, configType);
            logger.info("配置文件加载成功，配置如下:");
            logger.info(cfg.toString());
            return cfg;
        } catch (Exception e) {
            logger.error("[ConfigContext] Error reading config![" + path + "]", e);
            try {
                return configType.newInstance();
            } catch (Exception e1) {
                return null;
            }
        }
    }

    public Map<String, Resource> getResources() {
        return resources;
    }

    public void setResources(Map<String, Resource> resources) {
        this.resources = resources;
    }

    public Resource getRoot() {
        return root;
    }

    public void setRoot(Resource root) {
        this.root = root;
    }

}