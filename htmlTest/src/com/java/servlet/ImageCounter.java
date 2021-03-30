package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageCounter
 */
@WebServlet("/ImageCounter")
public class ImageCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int cnt;
	int zeroCount;
	public void init() {
		cnt=0;
		zeroCount=8;
	}
    
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>hello</title></head>");
		out.print("<body>");
		
		cnt+=1;
		
		String toCnt = Integer.toString(cnt);

		for(int i=1;i<zeroCount-toCnt.length();i++) {
			
			out.print("<img src='/htmlTest/servlet/img/0.jpg' width='100' height='100'>");
		}
		for(int i=0;i<toCnt.length();i++) {
			if(toCnt.charAt(i)=='0') {
				out.print("<img src='/htmlTest/servlet/img/0.jpg' width='100' height='100'>");
			}
			else if(toCnt.charAt(i)=='1') {
				out.print("<img src='/htmlTest/servlet/img/1.jpg' width='100' height='100'>");
			}
			else if(toCnt.charAt(i)=='2') {
				out.print("<img src='/htmlTest/servlet/img/2.jpg' width='100' height='100'>");
			}
			else if(toCnt.charAt(i)=='3') {
				out.print("<img src='/htmlTest/servlet/img/3.jpg' width='100' height='100'>");
			}
			else if(toCnt.charAt(i)=='4') {
				out.print("<img src='/htmlTest/servlet/img/4.jpg' width='100' height='100'>");
			}
			else if(toCnt.charAt(i)=='5') {
				out.print("<img src='/htmlTest/servlet/img/5.jpg' width='100' height='100'>");
			}
			else if(toCnt.charAt(i)=='6') {
				out.print("<img src='/htmlTest/servlet/img/6.jpg' width='100' height='100'>");
			}
			else if(toCnt.charAt(i)=='7') {
				out.print("<img src='/htmlTest/servlet/img/7.jpg' width='100' height='100'>");
			}
			else if(toCnt.charAt(i)=='8') {
				out.print("<img src='/htmlTest/servlet/img/8.jpg' width='100' height='100'>");
			}
			else if(toCnt.charAt(i)=='9') {
				out.print("<img src='/htmlTest/servlet/img/9.jpg' width='100' height='100'>");
			}
		}
			out.print("</body>");
			out.print("</html>");
	}
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
