package com.bjsxt.dao;

import com.bjsxt.pojo.User;

public interface UserDao {

	User checkUserLoginDao(String uname, String pwd);

}
