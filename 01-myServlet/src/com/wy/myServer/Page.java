package com.wy.myServer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page
 */
public class Page extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext c = this.getServletContext();
		if(c.getAttribute("nums")==null) {
			c.setAttribute("nums", 1);
			resp.getWriter().write((int) c.getAttribute("nums"));
			System.out.println(c.getAttribute("nums"));

		}
		else {
			int num = (int) c.getAttribute("nums");
			num+=1;
			c.setAttribute("nums", num);
			resp.getWriter().write((int) c.getAttribute("nums"));
			System.out.println(c.getAttribute("nums"));
		}
		
	}
}
