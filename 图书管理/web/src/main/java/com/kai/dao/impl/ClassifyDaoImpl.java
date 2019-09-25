package com.kai.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.kai.bean.Classify;
import com.kai.dao.ClassifyDao;
import com.kai.util.SessionUtil;

public class ClassifyDaoImpl implements ClassifyDao{

	@Override
	public Classify getClassify(int classify_id) {
		Classify classify=null;
		Session session=SessionUtil.getSession();
		try {
			Transaction tx=session.beginTransaction();
			classify=session.get(Classify.class, classify_id);
			tx.commit();
		}finally {
			session.close();
		}
		return classify;
	}

	@Override
	public List<Classify> getAll() {
		List<Classify> lists=null;
		Session session=SessionUtil.getSession();
		try {
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("FROM Classify");
			lists=query.list();
			tx.commit();
		}finally {
			session.close();
		}
		return lists;
	}

	@Override
	public boolean exist(int classify_id) {
		boolean flag=false;
		Session session=SessionUtil.getSession();
		try {
			Transaction tx=session.beginTransaction();
			Classify result=session.get(Classify.class, classify_id);
			if(result!=null) {
				flag=true;
			}
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			session.close();
		}
		return flag;
	}

	@Override
	public boolean delete(int classify_id) {
		boolean flag=false;
		Session session=SessionUtil.getSession();
		try {
			Transaction tx=session.beginTransaction();
			Classify classify=session.get(Classify.class, classify_id);
			session.delete(classify);
			tx.commit();
			flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			session.close();
		}
		return flag;
	}

	@Override
	public boolean update(Classify classify) {
		boolean flag=false;
		Session session=SessionUtil.getSession();
		try {
			Transaction tx=session.beginTransaction();
			Classify result=session.get(Classify.class, classify.getClassifyId());
			result.setClassifyName(classify.getClassifyName());
			tx.commit();
			flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			session.close();
		}
		return flag;
	}

	@Override
	public boolean addClassify(Classify classify) {
		boolean flag=false;
		Session session=SessionUtil.getSession();
		try {
			Transaction tx=session.beginTransaction();
			session.save(classify);
			tx.commit();
			flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			session.close();
		}
		return flag;
	}

}
