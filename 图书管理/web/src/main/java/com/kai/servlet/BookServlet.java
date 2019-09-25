package com.kai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kai.bean.Book;
import com.kai.bean.Classify;
import com.kai.dao.BookDao;
import com.kai.dao.ClassifyDao;
import com.kai.dao.impl.BookDaoImpl;
import com.kai.dao.impl.ClassifyDaoImpl;

public class BookServlet extends HttpServlet {
	HttpSession session=null;
	BookDao bookDao=new BookDaoImpl();
	ClassifyDao classifyDao=new ClassifyDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("classifyId")!=null) {
			int classify_id=Integer.valueOf(new String(request.getParameter("classifyId").getBytes("ISO-8859-1"),"utf-8"));
			session=request.getSession();
			session.setAttribute("classify_id", classify_id);			
		}
		System.out.println(request.getParameter("classify"));
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		int classify_id;
		if(session.getAttribute("classify_id")==null) {
			classify_id=1000;
			session.setAttribute("classify_id", 1000);
		}else {
			classify_id=(int) session.getAttribute("classify_id");
		}
		session.setAttribute("books", findByClassify_id(classify_id));
		session.setAttribute("classify", getClassify(classify_id));
		session.setAttribute("classifys", getAll());
		response.sendRedirect("listbook.jsp");
	}
	//根据分类获取图书列表
	public List findByClassify_id(int classify_id) {
		List<Book> lists=bookDao.findByClassify_id(classify_id);
		return lists;
	}
	//根据classify_id获取图书分类信息
	public Classify getClassify(int classify_id) {
		Classify classify=classifyDao.getClassify(classify_id);
		return classify;
	}
	//获取所有图书分类信息
	public List<Classify> getAll(){
		List<Classify> lists=classifyDao.getAll();
		return lists;
	}
}
