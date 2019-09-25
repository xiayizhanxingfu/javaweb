package com.kai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kai.bean.Classify;
import com.kai.dao.ClassifyDao;
import com.kai.dao.impl.ClassifyDaoImpl;

public class ClassifyBookServlet extends HttpServlet {
	HttpSession session=null;
	ClassifyDao classifyDao=new ClassifyDaoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		List<Classify> classifybooks=classifyDao.getAll();
		session.setAttribute("classifybooks", classifybooks);
		response.sendRedirect("classifybook.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
