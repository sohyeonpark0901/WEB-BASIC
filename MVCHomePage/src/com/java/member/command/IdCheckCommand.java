package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;
import com.java.member.model.MemberDao;

public class IdCheckCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		int check = MemberDao.getInstance().idCheck(id);
		
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		
		return "/WEB-INF/view/member/idCheck.jsp";
	}
	
}
