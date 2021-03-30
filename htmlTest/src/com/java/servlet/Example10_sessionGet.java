package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Example10_sessionGet
 */
@WebServlet("/Example10_sessionGet")
public class Example10_sessionGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Example10_sessionGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(!session.isNew()) {
			String id = (String) session.getAttribute("id");
			String pwd = (String) session.getAttribute("pwd");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
			out.print("<h3> 아이디: "+id+"</h3>");
			out.print("<h3> 비밀번호: "+pwd+"</h3>");
			out.print("</body>");
			out.print("</html>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
