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
		System.out.println("我是doGet方法");
		 
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
		System.out.println("请求方式："+req.getMethod());
		System.out.println("请求URL："+req.getRequestURL());
		System.out.println("请求的URI："+req.getRequestURI());
		System.out.println("协议："+req.getScheme());
		//对请求行数据进行操作,打印所有键与值
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements())
		{	String key = (String) e.nextElement();
			System.out.println(key+":"+req.getHeader(key));
		}
		//对用户数据进行操作
		System.out.println(req.getParameter("username")+":"+req.getParameter("password"));
		
	}
}
