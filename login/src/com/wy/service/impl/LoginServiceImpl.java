package com.wy.service.impl;

import java.sql.SQLException;

import javax.security.auth.spi.LoginModule;

import com.wy.dao.LoginDaoImpl;
import com.wy.pojo.User;
import com.wy.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public User checkLoginService(String username, String password) throws SQLException {
		LoginDaoImpl dao =new LoginDaoImpl();
		return dao.CheckLoginDao(username, password);
	}

	public User checkCookie(String uid) throws SQLException {
		
		LoginDaoImpl dao =new LoginDaoImpl();
		return dao.checkCookie(uid);
		
	}
		
}
