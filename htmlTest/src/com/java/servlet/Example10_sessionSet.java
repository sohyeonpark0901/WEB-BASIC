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
 * Servlet implementation class Example10_sessionSet
 */
@WebServlet("/Example10_sessionSet")
public class Example10_sessionSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Example10_sessionSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		System.out.println(id+"\t"+pwd);
		
		HttpSession session = request.getSession();
		String msg = "";
		if(session.isNew()&& session.getAttribute("id")!=null) {
			msg="새로운 세션이 생성";
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);
		}else {
			if(session.getAttribute("id")==null){
				session.removeAttribute("id");
				session.removeAttribute("pwd");
				
				session.setAttribute("id", id);
				session.setAttribute("pwd", pwd);
			}
			else{msg="기존 세션이 반환";
			}
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<script>");
		out.print("alert('"+msg+" : 로그인 성공');");
		out.print("location.href='http://localhost:8081/htmlTest/servlet/10_Example.html';");
		out.print("</script>");
		out.print("</body>");
		out.print("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
