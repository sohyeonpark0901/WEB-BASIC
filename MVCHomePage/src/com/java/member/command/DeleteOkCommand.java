package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.Command;
import com.java.member.model.MemberDao;

public class DeleteOkCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		System.out.println(password);
		
		int check=MemberDao.getInstance().deleteCheck(id,password);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/member/deleteOk.jsp";
	}

}
