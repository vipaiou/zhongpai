package com.supertool.dspui.util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class PropertyReader {

	private static final String JDBC_PROPERTIES = "jdbc.properties";

	private static Properties ps;

	static {
		ps = new Properties();
		try {
			// JDBC_PROPERTIES位于 类路径下
			InputStream in = PropertyReader.class.getClassLoader()
					.getResourceAsStream(JDBC_PROPERTIES);

			ps.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return (String) ps.get(key);
	}

	public static void main(String[] args) {
		System.out.println(get("URL"));

		// test
		try {
			Connection connection = ConnectionProvider.getConnection();
			if (connection != null) {
				System.out.println("connection != null.");
				connection.close();
			} else {
				System.out.println("connection = null.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}