package com.supertool.dspui.config;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

//import javax.annotation.PostConstruct;

public class Config {
	
	private static final String CARBON_HOST = "carbon_host";
	private static final String FILENAME = "/config.properties";
	private static String imageHost;
	private static boolean debug;
	private static String datasourceFilePath;
//	@PostConstruct
//    public void init() {
//        new Config();
//    }

	private Config() {
        try {
            URL url = this.getClass().getResource(FILENAME);
            InputStream is = url.openStream();
            Properties props = new Properties();
            props.load(is);
            imageHost = props.getProperty(CARBON_HOST);
            debug = "true".equals(props.getProperty("debug"));
            datasourceFilePath = props.getProperty("datasource_file_path");
            System.out.println(imageHost);
            System.out.println(debug);
            System.out.println(datasourceFilePath);
        }catch (Exception e) {
			System.out.println("config load error");
		}
	}
	
	public static boolean isDebug() {
		return debug;
	}

	public static void setDebug(boolean debug) {
		Config.debug = debug;
	}

	public static String getDatasourceFilePath() {
		return datasourceFilePath;
	}

	public static void setDatasourceFilePath(String datasourceFilePath) {
		Config.datasourceFilePath = datasourceFilePath;
	}

	public static String getImageHost() {
		return imageHost;
	}

	public static void setImageHost(String imageHost) {
		Config.imageHost = imageHost;
	}

}
