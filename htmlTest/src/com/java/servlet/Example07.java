package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example07
 */
@WebServlet("/Example07")
public class Example07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head><title>hello</title></head>");
		out.print("<body>");
		out.print("<h3>환영합니다.</h3>");
		
		out.print("</body>");
		out.print("</html>");
	}

}
