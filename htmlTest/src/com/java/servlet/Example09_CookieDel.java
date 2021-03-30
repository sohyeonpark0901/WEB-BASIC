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
 * Servlet implementation class Example09_CookieDel
 */
@WebServlet("/Example09_CookieDel")
public class Example09_CookieDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Example09_CookieDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for (int i = 0; i < cookies.length; i++) {
				//쿠키 지우기
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<script type='text/javascript'>");
		out.print("alert('장바구니를 비웠습니다');");
		out.print("location.href='http://localhost:8081/htmlTest/servlet/09_Example.html'");
		out.print("</script>");
		out.print("</body>");
		out.print("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
