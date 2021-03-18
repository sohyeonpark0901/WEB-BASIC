package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;
import com.java.member.model.MemberDao;
import com.java.member.model.MemberDto;

public class UpdateOkCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(id);
		memberDto.setNum(num);
		memberDto.setPassword(request.getParameter("password"));
		memberDto.setEmail(request.getParameter("email"));
		memberDto.setZipcode(request.getParameter("zipcode"));
		memberDto.setAddress(request.getParameter("address"));
		memberDto.setJob(request.getParameter("job"));
		memberDto.setMailing(request.getParameter("mailing"));
		memberDto.setInterest(request.getParameter("resultInterest"));
		
		
		logger.info(logMsg + memberDto.toString());
		
		
		//DAO
		int check = MemberDao.getInstance().update(memberDto);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/member/updateOk.jsp"; 
	}

}
