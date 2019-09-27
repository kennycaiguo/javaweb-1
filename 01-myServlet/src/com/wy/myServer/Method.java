package com.wy.myServer;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Method
 */
public class Method extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Method() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("����doGet����");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("����ʽ��"+req.getMethod());
		System.out.println("����URL��"+req.getRequestURL());
		System.out.println("�����URI��"+req.getRequestURI());
		System.out.println("Э�飺"+req.getScheme());
		//�����������ݽ��в���,��ӡ���м���ֵ
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements())
		{	String key = (String) e.nextElement();
			System.out.println(key+":"+req.getHeader(key));
		}
		//���û����ݽ��в���
		System.out.println(req.getParameter("username")+":"+req.getParameter("password"));
		
	}
}
