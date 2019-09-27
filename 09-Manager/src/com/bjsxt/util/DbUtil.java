package com.bjsxt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbUtil {
//	public static final String jdbcName = "com.mysql.jdbc.Driver";
//	public static String url="jdbc:mysql://localhost:3306/information";
//	public static String user = "root";
//	public static String password = "998520";
	private String jdbcName;
	private String dbName;
	private String url;
	private String user;
	private String password;
	public DbUtil(String jdbcName,String url,String user,String password) {
		this.jdbcName=jdbcName+"/"+dbName;
		this.url=url;
		this.user=user;
		this.password=password;
	}
	/*
	 * 建立连接
	 */
	public  Connection getConnection() throws Exception{
		Class.forName(jdbcName);
		Connection connection = DriverManager.getConnection(url, user,password);
		return connection;
	}
	public static void executeClose(Connection con) throws SQLException
	{
		con.close();
	}
	/*
	 * @method close() 关闭所有连接
	 */
	public  void close(Statement s, Connection con) throws SQLException {
		con.close();
		if(con==null)
		{
			s.close();
		}
	}
	/*
	 * 查询功能
	 */
	//statment方式
public static ResultSet querySql(Statement st,String sql) {
	ResultSet result =null;
	try {
		result= st.executeQuery(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		return result;
	}
	
}
	//PreparedStatement 方式
public static ResultSet querySql(PreparedStatement pst,String sql,ArrayList list) {
	//使用
	return null;
	
}
}
