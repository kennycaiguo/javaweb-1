package com.wy.service;

import java.sql.SQLException;

import com.wy.pojo.User;

public interface LoginService {
	User checkLoginService(String username,String password)throws SQLException;
	User checkCookie(String uid) throws SQLException;
}
