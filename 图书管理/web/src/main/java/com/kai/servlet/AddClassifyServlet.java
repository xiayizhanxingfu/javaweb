package com.kai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kai.bean.Classify;
import com.kai.dao.ClassifyDao;
import com.kai.dao.impl.ClassifyDaoImpl;

public class AddClassifyServlet extends HttpServlet {
	ClassifyDao classifyDao=new ClassifyDaoImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String classify_id=request.getParameter("classify_id");
		String classify_name=request.getParameter("classify_name");
		if(classifyDao.exist(Integer.valueOf(classify_id))) {
			System.out.println("己存在"+classify_id+"分类");
			response.sendRedirect("addclassify.jsp");
		}else {	
			Classify classify=new Classify();
			classify.setClassifyId(Integer.valueOf(classify_id));
			classify.setClassifyName(classify_name);
			if(classifyDao.addClassify(classify)) {
				System.out.println("添加分类成功");
				response.sendRedirect("classifybook");
			}else {
				System.out.println("添加分类失败");
			}
		}
	}

}
