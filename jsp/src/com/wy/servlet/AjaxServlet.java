package com.wy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 //设置请求编码格式	
	 	req.setCharacterEncoding("utf-8");
	 //设置响应编码格式
	 	resp.setContentType("text/html");
	 	resp.setCharacterEncoding("utf-8");
	 	//获取请求数据
	 	String name=req.getParameter("username");
	 	String pwd=req.getParameter("pwd");
	 	System.out.println(name+":"+pwd+","+req.getMethod());
	 	//处理请求数据
	 	//响应数据
	 	resp.getWriter().write("响应的处理结果");
	}

}
