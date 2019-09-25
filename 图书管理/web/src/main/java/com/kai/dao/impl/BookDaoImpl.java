package com.kai.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.kai.bean.Book;
import com.kai.dao.BookDao;
import com.kai.util.SessionUtil;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> findByClassify_id(int classify_id) {
		List<Book> lists=null;
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		try {
			Transaction tx=session.beginTransaction();
			Query query=session.createQuery("FROM Book where classify_id = :classify_id");
			query.setParameter("classify_id", classify_id);
			lists=query.list();
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return lists;
	}

	@Override
	public boolean deleteById(int id) {
		boolean flag=false;
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		try {
			Transaction tx=session.beginTransaction();
			Book b=session.get(Book.class, id);
			session.delete(b);
			tx.commit();
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			session.close();
		}
		return flag;
	}

	@Override
	public boolean update(Book book) {
		boolean flag=false;
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		try {
			Transaction tx=session.beginTransaction();
			Book result=session.get(Book.class, book.getId());
			result.setBookName(book.getBookName());
			result.setBookAuthor(book.getBookAuthor());
			result.setBookIsbn(book.getBookIsbn());
			tx.commit();
			flag=true;
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}finally {
			session.close();
		}
		return flag;
	}

	@Override
	public boolean addBook(Book book) {
		boolean flag=false;
		Session session=SessionUtil.getSession();
		try {
			Transaction tx=session.beginTransaction();
			session.save(book);
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
