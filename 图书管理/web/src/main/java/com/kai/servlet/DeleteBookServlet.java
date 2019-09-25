package com.kai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kai.dao.BookDao;
import com.kai.dao.impl.BookDaoImpl;

public class DeleteBookServlet extends HttpServlet {

	BookDao bookDao=new BookDaoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		if(request.getParameter("id")==null) {
			System.out.println("删除失败");
		}
		id=Integer.valueOf(request.getParameter("id"));
		if(bookDao.deleteById(id)) {
			System.out.println("删除成功");
			request.getRequestDispatcher("bookServlet").forward(request, response);
		}else {
			System.out.println("删除失败");
		}
	}

}
