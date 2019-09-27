package com.wy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import com.mysql.jdbc.Statement;

public class DbUtil {
	public static final String jdbcName = "com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://101.37.174.16:3306/remote_connect";
	public static String user = "wy";
	public static String password = "998520";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
	}
	public static void close(Connection con , PreparedStatement pstmt) throws SQLException
	{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
		{
			con.close();
		}
		
	}
}
