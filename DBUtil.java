package com.cg.asset.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection conn=null;
	public static Connection establishConnection() throws SQLException
	{
		conn=DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521:orcl","trg213","training213");
		return conn;
	}

}
