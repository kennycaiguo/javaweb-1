
package com.wy.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wy.pojo.User;
import com.wy.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class CkeckCookie
 */
@WebServlet("/CkeckCookie")
public class CkeckCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CkeckCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] c = req.getCookies();
		if(c!=null) {
			String uid="";
			for(Cookie cookie : c)
			{
				if("uid".equals(cookie.getName())) {
					uid=cookie.getValue();
				}
			}
			//�ض���
			if(uid=="") {
				resp.sendRedirect("/login/Page");
				return ;
			}
			else {
				LoginServiceImpl cookieCheck = new LoginServiceImpl();
				try {
					User user = cookieCheck.checkCookie(uid);
					//�ж��û������Ƿ���ڣ���cookie�洢����ɾ���û�����Ҫ�жϣ�
					if(user!=null) {
						//�����û�������Ϣ,��
						HttpSession session= req.getSession();
						session.setAttribute("user", user);
						/**
						 * �����û���¼���м�������Ϣ����ֱ�ӵ������ʴ���
						 */
							
							int num =(int) this.getServletContext().getAttribute("nums");
							num+=1;
							this.getServletContext().setAttribute("nums", num);
						//�ض���
						resp.sendRedirect("/login/main");
					}
					else {
						resp.sendRedirect("/login/Page");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			resp.sendRedirect("/login/Page");
			return ;
		}
	}
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