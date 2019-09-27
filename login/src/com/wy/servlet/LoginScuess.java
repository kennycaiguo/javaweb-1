package com.wy.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wy.pojo.User;

/**
 * Servlet implementation class LoginScuess
 */
@WebServlet("/main")
public class LoginScuess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginScuess() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	resp.setContentType("text/html;charset=utf-8");
	    	req.setCharacterEncoding("utf-8");
    		HttpSession s =req.getSession();
    		User value = (User)s.getAttribute("user");
    		ServletContext context =this.getServletContext();
    		resp.getWriter().write("被访问："+context.getAttribute("nums"));
    		resp.getWriter().write("登录成功，欢迎"+value.getUserName());
    		resp.getWriter().write(value.getUid()+":"+value.getUserName()+":"+value.getPassword());
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
