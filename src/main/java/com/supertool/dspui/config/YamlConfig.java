package com.supertool.dspui.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;

public class YamlConfig {

    private static Logger logger = LoggerFactory.getLogger(YamlConfig.class);
    private Resource resource;
    private static Config cfg = null;

    public YamlConfig() {
    }

    public static Config get() {
        return cfg;
    }

    /**
     * 加载配置文件，由Spring调用(Spring初始化后提供yaml的地址)
     * 
     */
    public void loadConfig() {
        try {
            String path = this.resource.getFile().getAbsolutePath();
            readConfig(path);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error loading config!");
        }
    }

    public void readConfig(String path) {
        try {
            cfg = YamlConfig.load(path, Config.class);
            logger.info("配置文件加载成功，配置如下:");
            logger.info(cfg.toString());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error reading config![" + path + "]");
        }
    }

    /**
     * 加载配置文件，读取成Config类
     * @param path 配置文件的路径
     * @param configClass 配置的类
     * @return
     */
    public static <E> E load(String path, Class<E> configClass) {
        try {
            Yaml y = new Yaml(new Constructor(configClass));
            @SuppressWarnings("unchecked")
            E cfg = (E) y.load(path);
            return cfg;
        } catch (YAMLException e) {
            logger.error("Yaml配置文件格式错误！[" + path + "]: " + root(e).getMessage(), e);
            return null;
        }
    }
    
    private static Throwable root(Throwable e) {
        Throwable r = e;
        Throwable p = e.getCause();
        while (p != null) {
            r = p;
            p = p.getCause();
        }
        return r;
    }
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

}