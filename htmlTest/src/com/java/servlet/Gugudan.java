package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gugudan
 */
@WebServlet("/Gugudan")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>hello</title></head>");
		out.print("<body>");
		out.print("<table border='1px solid black' width='600' height='400' >");
		out.print("<caption>*구구단*</caption>");
		for(int i=2;i<=9;i++) {
			out.print("<tr>");
			for(int j=1;j<=9;j++) {
				if(j%2==0) {
					out.print("<td bgcolor='pink' align='center'>"+i+"*"+j+"="+(i*j)+"</td>");
				}
				else {
				out.print("<td bgcolor='skyblue' align='center'>"+i+"*"+j+"="+(i*j)+"</td>");
				}
			}
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
