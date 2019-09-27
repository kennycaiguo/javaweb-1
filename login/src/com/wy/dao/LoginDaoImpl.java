package com.wy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wy.pojo.User;
import com.wy.util.DbUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User CheckLoginDao(String username, String password) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		User user=null;
		ResultSet result=null;
		try {
			con = DbUtil.getConnection();
			String sql= "select * from t_user where username=? and password=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			result = pstmt.executeQuery();
			if(result.next())
			{
				user =new User();
				user.setUid(result.getInt("uid"));
				user.setUserName(result.getString("username"));
				user.setPassword(result.getString("password"));
			}
			else {
				user =new User();
				user.setPassword("0");
				user.setUid(0);
				user.setUserName("0");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			result.close();//对单行数据进行操作
			DbUtil.close(con, pstmt);
		}
		return user;
	}

	public User checkCookie(String uid) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		User user=null;
		ResultSet result=null;
		try {
			con = DbUtil.getConnection();
			String sql= "select * from t_user where uid=?";
			pstmt= con.prepareStatement(sql);
			int id =Integer.valueOf(uid).intValue();
			pstmt.setInt(1, id);
			result = pstmt.executeQuery();
			if(result.next())
			{
				user =new User();
				user.setUid(result.getInt("uid"));
				user.setUserName(result.getString("username"));
				user.setPassword(result.getString("password"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				result.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//对单行数据进行操作
			try {
				DbUtil.close(con, pstmt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
		
		
	}

}
