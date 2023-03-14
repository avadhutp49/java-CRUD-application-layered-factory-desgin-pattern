package com.avadhutp49.util;


import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	
	private JdbcUtil(){
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	method to create a connection object
	public static Connection getJdbcConnection() throws Exception {
		HikariConfig config = new HikariConfig("/home/avadhutp49/eclipse-workspace/JDBC_CRUDApp/src/application.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource.getConnection();
	}
	
//	public static Connection getJdbcConnection() throws Exception{
//		FileInputStream fis = new FileInputStream("/home/avadhutp49/eclipse-workspace/JDBC_CRUDApp/src/application.properties");
//		Properties p = new Properties();
//		p.load(fis);
//		return DriverManager.getConnection(p.getProperty("dbcUrl"),p.getProperty("dataSource.user"),p.getProperty("dataSource.password"));
//	}
}