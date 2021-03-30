package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example01
 */
@WebServlet("/Example01")
public class Example01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Example01() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //생명주기 - 생성 후 초기화 init() -> 서비스 service() -> 소멸 destroy()
	public void init() {
			System.out.println("서블릿 요청으로 단 한번");
			System.out.println("오호 초기화가 되네");
	}
    
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//서비스 - 요청방식에 의해서 get,post 함수 호출
		doGet(request,response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서비스가 호출한 doGet함수 입니다.");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void destroy() {
		System.out.println("서블릿 소멸");
	}

}
