package com.servlet;

import com.service.TopSearchService;
import com.service.impl.TopSearchServiceImpl;
import com.util.JSON;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TopSearchServlet extends HttpServlet {

    TopSearchService topSearchService=new TopSearchServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置跨域请求
        response.setHeader("Access-Control-Allow-Origin","*");
        //处理中文乱码
        response.setContentType("text/html;charset=utf-8");
        //获取热搜列表
        List<String> lists=topSearchService.list();
        PrintWriter out=response.getWriter();
        if (lists.size() > 0) {
            out.println(JSON.toJson(lists));
        }
    }


}
