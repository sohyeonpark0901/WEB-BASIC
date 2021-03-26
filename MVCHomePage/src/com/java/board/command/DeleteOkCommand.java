package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.model.BoardDao;
import com.java.board.model.BoardDto;
import com.java.command.Command;

public class DeleteOkCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		int check = BoardDao.getInstance().delete(boardNumber);
		
		request.setAttribute("check", check);
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("pageNumber", pageNumber);
		return "/WEB-INF/view/board/deleteOk.jsp";
	}

}
