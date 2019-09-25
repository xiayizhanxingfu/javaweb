package com.kai.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kai.bean.Users;
import com.kai.dao.UserDao;

public class UserDaoimpl implements UserDao {

	@Override
	public boolean login(String user, String pwd) {
		boolean flag=false;
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		try {
			Transaction tx=session.beginTransaction();
			Users users=new Users(Integer.valueOf(user),pwd);
			Users result=session.get(Users.class, Integer.valueOf(user));
			if(result.getPwd().equals(users.getPwd())) {
				flag=true;
			}
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
