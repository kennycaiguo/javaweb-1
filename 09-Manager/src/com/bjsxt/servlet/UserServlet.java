package com.bjsxt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//������־����
	Logger logger = Logger.getLogger(UserServlet.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		// �����������
		req.setCharacterEncoding("utf-8");
		//��ȡ������
		String oper = req.getParameter("oper");
		if("login".equals(oper)) {
			checkUserLogin(req, resp);
		}else if("reg".equals(oper)){
			//ע��
			
		}else if("out".equals(oper)){
			//�˳�
			//��ȡ��ǰsession
			HttpSession session =req.getSession();
			//ǿ���˳�session
			session.invalidate();
			//�ض���login.jsp
			resp.sendRedirect("/mg/login.jsp");
			
		}else{
			logger.debug("û�л�ȡ��Ӧ�Ĳ�����"+oper);
		}
	}

	public void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡ������Ϣ
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		// ����������Ϣ
		// ��ȡservice�����
		UserService check = new UserServiceImpl();
		// У��
		User u = check.checkUserLoginService(uname, pwd);
		// ��Ӧ������
		if (u == null) {
			//�洢��ʾ��
			req.setAttribute("error", 0);
			//����ת����login.jspҳ�棬����ת�����Ը���ʧ���ж�����,���ݲ�����
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			//��ȡsession����
			HttpSession session =req.getSession();
			//�����û�������Ϣ
			session.setAttribute("user", u);
			try {
				// �ض���main
				//д����·������ֹservlet��Ŀ¼��ʽ
				resp.sendRedirect("/mg/main/main.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
