package com.wy.dao;

import java.sql.SQLException;

import com.wy.pojo.User;

public interface LoginDao {
	public User CheckLoginDao(String username,String password) throws SQLException;
}
