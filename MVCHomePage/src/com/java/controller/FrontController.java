package com.java.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;



public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final Logger logger = Logger.getLogger(FrontController.class.getName());
	
	public static final String logMsg = "logMSG!!!!";
	
	private HashMap<String,Object> commandmap = new HashMap<String,Object>();
	
	
    public FrontController() {
    	
        super();
       
    }
    
    
    public void init(ServletConfig config) throws ServletException{
    	
    	String configFile = config.getInitParameter("configFile");
    	
    	String path = config.getServletContext().getRealPath(configFile);
    	
    	logger.info(logMsg+path);
    	
    	FileInputStream fis = null;
    	
    	BufferedInputStream bis = null;
    	
    	Properties pro = new Properties();
    	
    	try {
    		fis = new FileInputStream(path);
    		bis = new BufferedInputStream(fis,1024);
    		pro.load(bis);
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    		if(fis!=null) {
    			fis.close();
    		}
    		if(bis!=null) {
    			bis.close();
    		}
    		}catch (Exception e2) {
    			e2.printStackTrace();
    		}
    	}
    	
    	//자바의 컬렉션에 저장되어있는 요소를 읽어오는 인터페이스
    	Iterator<Object> keyIter = pro.keySet().iterator();
    	
    	while(keyIter.hasNext()) {
    		
    		String command = (String) keyIter.next();
    		
    		String className = pro.getProperty(command);
    		
    		logger.info(command + "\t" + className);
    		
    		try {
    			
    			//객체에 대한 정보를 담는 handlerClass생성
    			Class<?> handlerClass = Class.forName(className);
    			
    			//정보를 이용하여 new를 통한 객체 생성
    			Object handlerInstance = handlerClass.getDeclaredConstructor().newInstance();
    			
    			commandmap.put(command, handlerInstance);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cmd = request.getServletPath();
		
		logger.info(cmd);
		
		String viewPage = null;
		
		try {
			
			Command com = (Command)commandmap.get(cmd);
			
			viewPage = com.proRequest(request, response);
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		if(viewPage!=null) {
			
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			
			rd.forward(request, response);
			
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
