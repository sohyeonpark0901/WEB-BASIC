package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example08
 */
@WebServlet("/Example08")
public class Example08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = request.getParameter("message");
		
		System.out.println(message);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		request.setAttribute("name", "박소현");
		request.setAttribute("phone", "010-2330-1558");
		RequestDispatcher re= request.getRequestDispatcher("/Example08_sub");
		re.include(request, response);
		
		
		
		
		
		out.print("</html>");
		out.print("</body>");
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String message = request.getParameter("message");
		
		System.out.println(message);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		request.setAttribute("name", "박소현");
		request.setAttribute("phone", "010-2330-1558");
		RequestDispatcher re= request.getRequestDispatcher("/Example08_sub");
		
		re.forward(request, response);
		
		
		
		
		out.print("</html>");
		out.print("</body>");
		out.close();
	}

}
