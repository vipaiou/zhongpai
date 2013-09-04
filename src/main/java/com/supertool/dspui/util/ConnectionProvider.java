package com.supertool.dspui.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接的提供类
 * 
 * @author leiwen@miaozhen.com
 * 
 */
public class ConnectionProvider {

	public static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url = PropertyReader.get("jdbc.url");
		String user = PropertyReader.get("jdbc.username");
		String password = PropertyReader.get("jdbc.password");

		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
		
		}

		return connection;
	}

}