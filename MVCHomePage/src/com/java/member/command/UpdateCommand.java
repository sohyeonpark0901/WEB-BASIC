package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.Command;
import com.java.member.model.MemberDao;
import com.java.member.model.MemberDto;

public class UpdateCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		
		//DAO
		MemberDto memberDto = new MemberDto();

		memberDto = MemberDao.getInstance().select(id);
				
		request.setAttribute("memberDto", memberDto);
		return "/WEB-INF/view/member/update.jsp"; 
	}

}
