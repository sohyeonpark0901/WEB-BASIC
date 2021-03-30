package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example09_CookieGet
 */
@WebServlet("/Example09_CookieGet")
public class Example09_CookieGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Example09_CookieGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				//key
				out.print("<h3>"+cookies[i].getName()+"</h3>");
				//value
				out.print("<h3>"+cookies[i].getValue()+"</h3>");
			}
			String contextPath = request.getContextPath();
			for (int i = 0; i < cookies.length; i++) {
				String imgstr = contextPath+"/img/"+cookies[i].getValue()+".jpeg";
				out.print("<img src='"+imgstr+"' width='200' height='150' />");
			}
			
		}
		else {
			out.print("<h3>장바구니가 비어있습니다.</h3>");
		}
		out.print("</body>");
		out.print("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
