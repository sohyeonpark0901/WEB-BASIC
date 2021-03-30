package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Example10_sessionDel
 */
@WebServlet("/Example10_sessionDel")
public class Example10_sessionDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Example10_sessionDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.isRequestedSessionIdValid()) {
			System.out.println("세션 아이디가 유효 합니다.");
		}
		else {
			System.out.println("세션 아이디가 유효 하지 않습니다..");
		}
		
		HttpSession session = request.getSession();
		if(!session.isNew()) {
			session.invalidate(); //세션 종료 메소드
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
