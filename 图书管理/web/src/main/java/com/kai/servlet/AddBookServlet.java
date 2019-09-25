package com.kai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kai.bean.Book;
import com.kai.dao.BookDao;
import com.kai.dao.ClassifyDao;
import com.kai.dao.impl.BookDaoImpl;
import com.kai.dao.impl.ClassifyDaoImpl;

public class AddBookServlet extends HttpServlet {
	BookDao bookDao=new BookDaoImpl();
	ClassifyDao classifyDao=new ClassifyDaoImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int classify_id=Integer.valueOf(request.getParameter("classify_id"));
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String book_isbn=request.getParameter("book_isbn");
		System.out.println(classify_id);
		System.out.println(classifyDao.exist(classify_id));
		if(!classifyDao.exist(classify_id)) {
			System.out.println("不存在这个分类");
			response.sendRedirect("addbook.jsp");//重定向到添加图书页面
			return;//防止后边语句运行
		}
		Book book=new Book();
		book.setBookName(name);
		book.setBookAuthor(author);
		book.setBookIsbn(book_isbn);
		book.setClassifyId(classify_id);
		if(bookDao.addBook(book)) {
			System.out.println("添加成功");
			response.sendRedirect("bookServlet");//重定向到图书列表页面
		}else {
			System.out.println("添加失败");
			response.sendRedirect("addbook.jsp");//重定向到添加图书页面
		}
	}

}
