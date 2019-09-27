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
	 //������������ʽ	
	 	req.setCharacterEncoding("utf-8");
	 //������Ӧ�����ʽ
	 	resp.setContentType("text/html");
	 	resp.setCharacterEncoding("utf-8");
	 	//��ȡ��������
	 	String name=req.getParameter("username");
	 	String pwd=req.getParameter("pwd");
	 	System.out.println(name+":"+pwd+","+req.getMethod());
	 	//������������
	 	//��Ӧ����
	 	resp.getWriter().write("��Ӧ�Ĵ�����");
	}

}
