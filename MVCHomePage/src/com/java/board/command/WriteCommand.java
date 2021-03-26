package com.java.board.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.model.BoardDao;
import com.java.board.model.BoardDto;
import com.java.command.Command;

public class WriteCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 부모글일 경우
		int boardNumber =0;
		int groupNumber =1; //부모글일 경우 상위 글번호가 존재하지 않는다.
		int sequenceNumber =0;
		int sequenceLevel = 0;
		
		
		
		
		//답글일 경우 부모글의 글번호, 그룹번호, 글순서, 글레벨을 가져온다
		if(request.getParameter("boardNumber")!=null) {
			boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
			groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
			sequenceNumber= Integer.parseInt(request.getParameter("sequenceNumber"));
			sequenceLevel =Integer.parseInt(request.getParameter("sequenceLevel"));
			
		}
		
		request.setAttribute("boardNumber",boardNumber);
		request.setAttribute("groupNumber",groupNumber);
		request.setAttribute("sequenceNumber",sequenceNumber);
		request.setAttribute("sequenceLevel",sequenceLevel);
		
		return "/WEB-INF/view/board/write.jsp";
	}

}
