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
		//��ӡ��־����
		logger.debug(uname+"�����¼����");
		User u = ud.checkUserLoginDao(uname,pwd);
		if(u!=null) {
			logger.debug(uname+"��¼�ɹ�");
		}else
		{
			logger.debug(uname+"��¼ʧ��");
		}
		return u;
	}

}
