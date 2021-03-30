package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹 2.5 vs 웹 3.0 이상버전의 차이
//웹 3.0이상의 버전에서는 web.xml 설정 대신에
//클레스의 어노테이션 방식으로 url-pattern을 설정할 수 있다.
@WebServlet("/helloServlet")
public class helloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int cnt;
	public void init() {
		cnt=0;
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt+=1;
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head><title>hello</title></head>");
		out.print("<body>");
		out.print("<h3>HelloServlet</h3>");
		out.print("<h3>당신은"+cnt+"번째 방문자입니다</h3>");
		out.print("</body>");
		out.print("</html>");
		}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
