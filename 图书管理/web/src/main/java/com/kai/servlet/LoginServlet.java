package com.kai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kai.dao.UserDao;
import com.kai.dao.impl.UserDaoimpl;

public class LoginServlet extends HttpServlet {
	private String user=null, pwd=null;
	UserDao userDao = new UserDaoimpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户信息
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null) {
			String user=new String(request.getParameter("username").getBytes("ISO-8859-1"),"utf-8");
			if(user==null) {
				response.sendRedirect("index.jsp");
				return;
			}
			session.setAttribute("user", user);
		}
		if(session.getAttribute("pwd")==null) {
			String pwd=new String(request.getParameter("password").getBytes("ISO-8859-1"),"utf-8");
			if(pwd==null) {
				response.sendRedirect("index.jsp");
				return;
			}
			session.setAttribute("pwd", pwd);
		}
		user=(String) session.getAttribute("user");
		pwd=(String) session.getAttribute("pwd");
		System.out.println(user+"\t"+pwd);
		if(!userDao.login(user,pwd)) {
			System.out.println("登录失败");
			response.sendRedirect("index.jsp");
			return;
		}else {
			System.out.println("登录成功");
			request.getRequestDispatcher("bookServlet").forward(request, response);
		}
	}

}
