package com.java.command;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	//요청에 대해서 FrontController(서블릿)에서 직접 처리하지 않고 해당 클래스가 처리하도록 한다.
	public Logger logger= Logger.getLogger(Command.class.getName());
	public String logMsg = "logMSG!!!!";
	
	public String proRequest(HttpServletRequest request,HttpServletResponse response) 
			throws Exception;
	
}
