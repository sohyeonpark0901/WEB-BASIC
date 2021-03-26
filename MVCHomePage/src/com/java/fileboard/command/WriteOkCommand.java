package com.java.fileboard.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.java.board.model.BoardDao;
import com.java.board.model.BoardDto;
import com.java.command.Command;

public class WriteOkCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
//		BoardDto boardDto = new BoardDto();
//		Connection conn =null;
//		
//		boardDto.setBoardNumber(Integer.parseInt(request.getParameter("boardNumber")));
//		boardDto.setGroupNumber(Integer.parseInt(request.getParameter("groupNumber")));
//		boardDto.setSequenceNumber(Integer.parseInt(request.getParameter("sequenceNumber")));
//		boardDto.setSequenceLevel(Integer.parseInt(request.getParameter("sequenceLevel")));
//		
//		boardDto.setWriter(request.getParameter("name"));
//		boardDto.setSubject(request.getParameter("subject"));
//		boardDto.setEmail(request.getParameter("email"));
//		boardDto.setContent(request.getParameter("content"));
//		boardDto.setPassword(request.getParameter("password"));
//		boardDto.setWriteDate(new Date());
//		
//		
//		int check = BoardDao.getInstance().insert(boardDto);
//		request.setAttribute("check", check);
		
		//파일 보관 객체
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//요청 처리 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> list = upload.parseRequest(request);
		Iterator<FileItem> iter = list.iterator();
		
		BoardDto boardDto = new BoardDto();
		HashMap<String,String> dataMap = new HashMap<String,String>();
		
		
		while(iter.hasNext()) {
			FileItem fileItem = iter.next();
			
			//파일데이터인지 일반 그외의 form데이터인지 확인
			if(fileItem.isFormField()) {
				String name = fileItem.getFieldName();
				String value = fileItem.getString("utf-8");
				dataMap.put(name, value);
			}else {
				if(fileItem.getFieldName().equals("file")) {
					if(fileItem.getName()==null||fileItem.getName().equals("")) {
						continue;
					}
					
					upload.setFileSizeMax(1024*1024*10); //byte/kb/mb/gb
					String fileName = System.currentTimeMillis()+"_"+fileItem.getName();
					String dir ="C:\\workspace\\web\\MVCHomePage\\pds";
					File file = new File(dir,fileName);
					
					BufferedInputStream bis = null;
					BufferedOutputStream bos = null;
					
					try {
						bis = new BufferedInputStream(fileItem.getInputStream(),1024);
						bos = new BufferedOutputStream(new FileOutputStream(file),1024);
						
						while(true) {
							int data = bis.read();
							
							if(data == -1) {
								break;
							}
							bos.write(data);
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						if(bis!=null) {
							bis.close();
						}
						if(bos!=null) {
							bos.close();
						}
					}
					
					boardDto.setFileName(fileName);
					boardDto.setFileSize(fileItem.getSize());
					boardDto.setPath(file.getAbsolutePath());
				}
			}
		}
		
		boardDto.setWriteDate(new Date());
		
		boardDto.setBoardNumber(Integer.parseInt(dataMap.get("boardNumber")));
		boardDto.setGroupNumber(Integer.parseInt(dataMap.get("groupNumber")));
		boardDto.setSequenceNumber(Integer.parseInt(dataMap.get("sequenceNumber")));
		boardDto.setSequenceLevel(Integer.parseInt(dataMap.get("sequenceLevel")));
		
		boardDto.setWriter(dataMap.get("name"));
		boardDto.setSubject(dataMap.get("subject"));
		boardDto.setEmail(dataMap.get("email"));
		boardDto.setContent(dataMap.get("content"));
		boardDto.setPassword(dataMap.get("password"));
		
		int check = BoardDao.getInstance().insert(boardDto);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/board2/writeOk.jsp"; 
	}

}
