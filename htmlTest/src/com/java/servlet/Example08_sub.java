package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Example08_sub")
public class Example08_sub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		String name = (String) request.getAttribute("name");
		String phone = (String) request.getAttribute("phone");
		
		System.out.println("Example08_sub"+message);
		System.out.println("Example08_sub"+name);
		System.out.println("Example08_sub"+phone);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h3 style='color:blue' width='400px'>"+message+"</h3>");
		out.print("<h3 style='color:blue' width='400px'>"+name+"</h3>");
		out.print("<h3 style='color:blue' width='400px'>"+phone+"</h3>");
		
		out.print("</html>");
		out.print("</body>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
