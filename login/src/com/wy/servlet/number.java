package com.wy.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/number")
public class number extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//服务器启动将计数器加载到context中
			@Override
			public void init() throws ServletException {
				FileReader fr = null;
				BufferedReader br=null;
				try {
					fr =new FileReader(this.getServletContext().getRealPath("/data/number.txt"));
					br =new BufferedReader(fr);
					if(br.readLine()!=null) {
						this.getServletContext().setAttribute("nums", Integer.valueOf(br.readLine()).intValue());
						System.out.println(Integer.valueOf(br.readLine()).intValue());
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			//服务器关闭时将数据存到文件中
		      private void destory() {
				int nums = (int) this.getServletContext().getAttribute("nums");
				FileWriter fw=null;
				BufferedWriter bw=null;
				try {
					fw=new FileWriter(this.getServletContext().getRealPath("/data/number.txt"));
					bw = new BufferedWriter(fw);
					bw.write(nums);
					bw.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		      }
		      @Override
		    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    	  resp.getWriter().write("手动加载");
		    }

}
