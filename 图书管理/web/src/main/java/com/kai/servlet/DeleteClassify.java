package com.kai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kai.dao.ClassifyDao;
import com.kai.dao.impl.ClassifyDaoImpl;

public class DeleteClassify extends HttpServlet {

	HttpSession session=null;
	ClassifyDao classifyDao=new ClassifyDaoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("classify_id")==null) {
			response.sendRedirect("index.jsp");
			return;
		}
		int classify_id=Integer.valueOf(new String(request.getParameter("classify_id").getBytes("ISO-8859-1"),"utf-8"));
		session=request.getSession();
		if(classifyDao.delete(classify_id)) {
			System.out.println("删除成功");
			response.sendRedirect("classifybook");
		}else {
			System.out.println("删除失败");
		}
	}

}
