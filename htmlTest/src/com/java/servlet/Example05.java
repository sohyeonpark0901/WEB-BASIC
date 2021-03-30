package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example05
 */
@WebServlet("/Example05")
public class Example05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num1 = request.getParameter("num1");
		String buho = request.getParameter("buho");
		String num2 = request.getParameter("num2");
		int result=0;
		
		if(buho.equals("+")) {
			result=Integer.parseInt(num1)+Integer.parseInt(num2);
		}
		else if(buho.equals("-")) {
			
			result=Integer.parseInt(num1)-Integer.parseInt(num2);
			System.out.println(result);
		}
		else if(buho.equals("*")) {
			result=Integer.parseInt(num1)*Integer.parseInt(num2);
		}
		if(buho.equals("/")) {
			result=Integer.parseInt(num1)/Integer.parseInt(num2);
		}
		System.out.print(num1+buho+num2+"=");
		System.out.println(result);
		
		//만들떄는 text로 만들고, 해석할 때는 html로 해석해, 모든문자는 utf-8 형식이야.
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>사칙연산</title></head>");
		out.print("<body>");
		out.print("<h3>결과</h3>"+result);
		out.print("</body>");
		out.print("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
