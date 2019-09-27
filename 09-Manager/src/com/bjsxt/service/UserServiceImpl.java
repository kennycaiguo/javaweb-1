package com.bjsxt.service;

import org.apache.log4j.Logger;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.UserDaoImpl;
import com.bjsxt.pojo.User;

public class UserServiceImpl implements UserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	UserDao ud=new UserDaoImpl();
	@Override
	public User checkUserLoginService(String uname, String pwd) {
		//打印日志对象
		logger.debug(uname+"发起登录请求");
		User u = ud.checkUserLoginDao(uname,pwd);
		if(u!=null) {
			logger.debug(uname+"登录成功");
		}else
		{
			logger.debug(uname+"登录失败");
		}
		return u;
	}

}
