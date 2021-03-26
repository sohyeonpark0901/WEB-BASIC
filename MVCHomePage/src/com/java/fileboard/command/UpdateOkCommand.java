package com.java.fileboard.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.model.BoardDao;
import com.java.board.model.BoardDto;
import com.java.command.Command;

public class UpdateOkCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		
		
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		BoardDto boardDto = new BoardDto();
		
		boardDto.setBoardNumber(boardNumber);
		boardDto.setSubject(request.getParameter("subject"));
		boardDto.setEmail(request.getParameter("email"));
		boardDto.setContent(request.getParameter("content"));
		boardDto.setPassword(request.getParameter("password"));
		boardDto.setWriteDate(new Date());
		
		int check = BoardDao.getInstance().update(boardDto);
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/board2/updateOk.jsp";
	}

}
