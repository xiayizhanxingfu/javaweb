package com.kai.dao;

public interface UserDao {

	/**
	 * 	管理员登录
	 * @param user
	 * @param pwd 
	 * @return
	 */
	boolean login(String user, String pwd);

}
