package com.wy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/Page")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
    	String str = (String) res.getAttribute("str");
    	if(str!=null)
    	{
    		resp.setContentType("text/html;charset=utf-8");
        	resp.getWriter().write("<html>");
        	resp.getWriter().write("<head>");
        	resp.getWriter().write("</head>");
        	resp.getWriter().write("<body>");
        	resp.getWriter().write("<form action=\"login\" method=\"post\">");
        	resp.getWriter().write( "用户名：<input type=\"text\" name=\"username\" value=\"\"/><br/>\r\n" + 
        			"密码：<input type=\"password\" name=\"password\" value=\"\"/><br/>\r\n" + 
        			"<input type=\"submit\" value=\"登录\">");
        	resp.getWriter().write("</form>");
        	resp.getWriter().write("<font color=\'red\' size=\'20px\'>"+str+"</font");
        	resp.getWriter().write("</body>");
        	resp.getWriter().write("</html>");
    	}
    	else {
    		resp.setContentType("text/html;charset=utf-8");
        	resp.getWriter().write("<html>");
        	resp.getWriter().write("<head>");
        	resp.getWriter().write("</head>");
        	resp.getWriter().write("<body>");
        	resp.getWriter().write("<form action=\"login\" method=\"post\">");
        	resp.getWriter().write( "用户名：<input type=\"text\" name=\"username\" value=\"\"/><br/>\r\n" + 
        			"密码：<input type=\"password\" name=\"password\" value=\"\"/><br/>\r\n" + 
        			"<input type=\"submit\" value=\"登录\">");
        	resp.getWriter().write("</form>");
        	resp.getWriter().write("</body>");
    	}
 
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
