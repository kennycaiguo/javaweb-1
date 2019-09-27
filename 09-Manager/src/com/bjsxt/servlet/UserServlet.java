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
	//声明日志对象
	Logger logger = Logger.getLogger(UserServlet.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置响应编码
		resp.setContentType("text/html;charset=utf-8");
		// 设置请求编码
		req.setCharacterEncoding("utf-8");
		//获取操作符
		String oper = req.getParameter("oper");
		if("login".equals(oper)) {
			checkUserLogin(req, resp);
		}else if("reg".equals(oper)){
			//注册
			
		}else if("out".equals(oper)){
			//退出
			//获取当前session
			HttpSession session =req.getSession();
			//强制退出session
			session.invalidate();
			//重定向到login.jsp
			resp.sendRedirect("/mg/login.jsp");
			
		}else{
			logger.debug("没有获取对应的操作符"+oper);
		}
	}

	public void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		// 处理请求信息
		// 获取service层对象
		UserService check = new UserServiceImpl();
		// 校验
		User u = check.checkUserLoginService(uname, pwd);
		// 响应处理结果
		if (u == null) {
			//存储提示语
			req.setAttribute("error", 0);
			//请求转发至login.jsp页面，请求转发可以给出失败判定条件,传递操作符
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			//获取session对象
			HttpSession session =req.getSession();
			//保存用户个人信息
			session.setAttribute("user", u);
			try {
				// 重定向main
				//写绝对路径，防止servlet是目录形式
				resp.sendRedirect("/mg/main/main.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
