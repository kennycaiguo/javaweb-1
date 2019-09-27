package com.bjsxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bjsxt.pojo.User;
import com.bjsxt.util.DbUtil;
import com.mysql.jdbc.Statement;

public class UserDaoImpl implements UserDao {
	//������־����
	Logger logger = Logger.getLogger(UserDaoImpl.class);
	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		//����ȫ�ֱ���
		Connection con=null;
		PreparedStatement pstm = null;
		User u=null;
		ResultSet result=null;
		try {
			//��������
			con=DbUtil.getConnection();
			String sql = "select * from t_user where uname=? and pwd=?";
			//��ѯ
			pstm = con.prepareStatement(sql);
			pstm.setString(1, uname);
			pstm.setString(2, pwd);
			result = pstm.executeQuery();
			//����user����
			if(result.next()) {
				u=new User();
				u.setUid(result.getInt("uid"));
				u.setUname(result.getString("uname"));
				u.setPwd(result.getString("pwd"));
				u.setAge(result.getInt("age"));
				u.setSex(result.getString("sex"));
				u.setBirth(result.getDate("birth"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				result.close();
				DbUtil.close(pstm, con);
			} catch (SQLException e) {
				logger.debug("���ݿ�ر�ʧ��");
				e.printStackTrace();
			}
		}
		return u;
	}

}
