package com.java.board.model;

import java.util.Date;

public class BoardDto {
	private int boardNumber;
	private String writer;
	private String subject;
	private String email;
	private String content;
	private String password;
	
	private Date writeDate;
	private int readCount;
	
	private long fileSize;
	private String fileName;
	private String path;
	public long getFileSize() {
		return fileSize;
	}


	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}





	@Override
	public String toString() {
		return "BoardDto [boardNumber=" + boardNumber + ", writer=" + writer + ", subject=" + subject + ", email="
				+ email + ", content=" + content + ", password=" + password + ", writeDate=" + writeDate
				+ ", readCount=" + readCount + ", fileSize=" + fileSize + ", fileName=" + fileName + ", path=" + path
				+ ", groupNumber=" + groupNumber + ", sequenceNumber=" + sequenceNumber + ", sequenceLevel="
				+ sequenceLevel + "]";
	}


	public BoardDto(int boardNumber, String writer, String subject, String email, String content, String password,
			Date writeDate, int readCount, long fileSize, String fileName, String path, int groupNumber,
			int sequenceNumber, int sequenceLevel) {
		super();
		this.boardNumber = boardNumber;
		this.writer = writer;
		this.subject = subject;
		this.email = email;
		this.content = content;
		this.password = password;
		this.writeDate = writeDate;
		this.readCount = readCount;
		this.fileSize = fileSize;
		this.fileName = fileName;
		this.path = path;
		this.groupNumber = groupNumber;
		this.sequenceNumber = sequenceNumber;
		this.sequenceLevel = sequenceLevel;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	private int groupNumber;
	private int sequenceNumber;
	private int sequenceLevel;
	
	
	public BoardDto() {
		super();
		
	}
	
	

	
	
	


	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public int getSequenceLevel() {
		return sequenceLevel;
	}
	public void setSequenceLevel(int sequenceLevel) {
		this.sequenceLevel = sequenceLevel;
	}
}
