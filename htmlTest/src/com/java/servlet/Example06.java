package com.java.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example06
 */
@WebServlet("/Example06")
public class Example06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Example06() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* request 객체의 역할 - 사용자의 요청
		 * 한글 Encoding 기능 
		 * 파라미터 읽기 기능 
		 * Server와 관련된 정보 읽기 기능
		 * 웹브라우저 관련 정보 읽기 기능
		 * 헤더 읽기 기능 
		 * 쿠키 읽기 기능
		 * 속성처리 기능
		 * */
		
		//한글 Encoding
		request.setCharacterEncoding("utf-8");
		//파라미터 읽기
		int su = Integer.parseInt(request.getParameter("su"));
		//서버와 관련된 정보 읽기 기능
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		
		System.out.println("serverName:" + serverName);
		System.out.println("serverport:" + serverPort);
		
		//웹브라우저 관련정보 읽기 기능
		//URL
		//프로토콜(http,https)부터 servlet파일까지의 경로를 나타낸다.
		StringBuffer URL = request.getRequestURL();
		System.out.println("URL:" + URL);
		
		//URI
		//context(프로젝트명)부터 시작해서 servlet파일 경로까지 경로를 나타낸다.
		String URI = request.getRequestURI();
		System.out.println("URI:" + URI);
		
		//프로젝트명만 가지고 오고 싶을 때
		String contextPath=request.getContextPath();
		System.out.println("contextPath: "+contextPath);
		
		//서블릿 path명만 가지고 싶을 때
		String servletPath = request.getServletPath();
		System.out.println("servletPath: "+servletPath);
		
		//클라이언트 정보
		System.out.println("요청프로토콜: "+request.getProtocol());
		//ip 주소 ipv6에 대한 정보를 얻어옴
		System.out.println("클라이언트 주소: "+request.getRemoteAddr());
		System.out.println("클라이언트 포트:" + request.getRemotePort());;
	
		//헤더읽기 기능
		Enumeration<String> header= request.getHeaderNames();
		while(header.hasMoreElements()) {
			String key = header.nextElement();
			String value = request.getHeader(key);
		}
		//쿠키 읽기 기능
		//속성처리 기능
		
		/* response 객체
		 * 문서 타입, 한글 설정 setContentType
		 * 출력 getWriter()
		 * 쿠키 저장(설정) 기능, 헤더설정(파일업로드일 때) 기능
		 * 페이지 이동 : sendRedirect
		 *  
		 * */
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
