package com.wy.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wy.pojo.User;
import com.wy.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");//utf8��ʽ���ַ����ô����iso����
		//username = new String((username.getBytes("iso8859-1")),"utf-8"); //�ô����ISO���룬������ȷ��utf8����
		String password = req.getParameter("password");
		//System.out.println(username+":"+password);
		LoginServiceImpl login = new LoginServiceImpl();
		User user=null;
		HttpSession session =req.getSession();
		try {
			user = login.checkLoginService(username, password);
			if(user.getUid()!=0&&user!=null) {
				Cookie cookie = new Cookie("uid",new Integer(user.getUid()).toString());
				cookie.setPath("/login/CkeckCookie");
				//cookie.setMaxAge(3*24*3600);
				resp.addCookie(cookie);
				session.setAttribute("user", user); //session��ʹ��
				//���÷��ʴ���
				ServletContext  context = this.getServletConfig().getServletContext();
				if(context.getAttribute("nums")!=null)
				{
					int num =(int) context.getAttribute("nums");
					num+=1;
					context.setAttribute("nums", num);
				}
				else {
					context.setAttribute("nums", 1);
				}
				resp.sendRedirect("main");  //�����ض���
				
			}else {
				req.setAttribute("str", "�û������������"); //�����Ϣ
				req.getRequestDispatcher("Page").forward(req, resp);
				return;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
