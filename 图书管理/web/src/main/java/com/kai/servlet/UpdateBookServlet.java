package com.kai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kai.bean.Book;
import com.kai.dao.BookDao;
import com.kai.dao.impl.BookDaoImpl;

public class UpdateBookServlet extends HttpServlet {

	HttpSession session = null;
	BookDao bookDao=new BookDaoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		if (request.getParameter("id") != null) {
			String id = new String(request.getParameter("id").getBytes("ISO-8859-1"), "utf-8");
			String classifyId=new String(request.getParameter("classifyId").getBytes("ISO-8859-1"),"utf-8");
			session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("classifyId", classifyId);
			response.sendRedirect("updatebook.jsp");
		} else {
			// 非正常途径访问,重定向到登录页面
			response.sendRedirect("index.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		session=request.getSession();
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		int id=Integer.valueOf((String)session.getAttribute("id"));
		String book_isbn=request.getParameter("book_isbn");
		Book book=new Book(id,name,author,book_isbn);
		if(bookDao.update(book)) {
			System.out.println("更新成功");
			response.sendRedirect("bookServlet?classifyId="+session.getAttribute("classifyId"));
		}else {
			System.out.println("更新失败");
		}
	}
}
