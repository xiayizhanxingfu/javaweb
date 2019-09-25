package com.kai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kai.bean.Classify;
import com.kai.dao.ClassifyDao;
import com.kai.dao.impl.ClassifyDaoImpl;

public class UpdateclassifyServlet extends HttpServlet {
	HttpSession session = null;
	ClassifyDao classifyDao = new ClassifyDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("classify_id") == null) {
			response.sendRedirect("index.jsp");
		}
		session = request.getSession();
		int classify_id = Integer
				.valueOf(new String(request.getParameter("classify_id").getBytes("ISO-8859-1"), "utf-8"));
		session.setAttribute("classify_id", classify_id);
		response.sendRedirect("updateclassify.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		request.setCharacterEncoding("utf-8");
		int classify_id = (int) session.getAttribute("classify_id");
		String classify_name = request.getParameter("classify_name");
		Classify classify = new Classify(classify_id, classify_name);
		if (classifyDao.update(classify)) {
			System.out.println("图书分类更新成功");
			response.sendRedirect("bookServlet");
		} else {
			System.out.println("图书分类更新失败");
		}
	}
}
