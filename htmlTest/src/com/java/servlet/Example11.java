package com.java.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Example11
 */
@WebServlet("/Example11")
public class Example11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Example11() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//세션 생성 시간
		long createTime = session.getCreationTime();
		
		//세션 마지막 접근 시간
		long lastTime = session.getLastAccessedTime();
		
		//사이트 머문 시간 = 마지막 접근시간 - 세션 생성시간
		long userTime =(lastTime-createTime)/60000;
		Date date = new Date(createTime);
		System.out.println("생성Time:" + createTime+"\t"+date);
		System.out.println("마지막Time:" + lastTime+"\t"+new Date(lastTime).toString());
		System.out.println("지속Time:" + userTime+"\t");
		
		int max = session.getMaxInactiveInterval();
		System.out.println(max +"\t" + max/60 );
		
		//액션이 없을 경우 세션 시간 설정으로 자동 종료
		if(request.isRequestedSessionIdValid()) {
			System.out.println("세션 아이디가 유효합니다.");
		}else {
			System.out.println("세션 아이디가 유효하지않습니다.");
		}
		//세션 종료 시간 설정
		session.setMaxInactiveInterval(60);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
