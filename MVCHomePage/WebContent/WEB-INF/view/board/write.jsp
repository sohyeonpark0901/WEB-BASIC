<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/board/boardStyle.css">
<script type="text/javascript" src="${root}/javascript/board/board.js"></script>
</head>
<body>
	<form id="createform" name="createform" 
	action="${root}/board/writeOk.do" method="post" onsubmit="return boardCheck(this)">
		<div id="title">글 목록</div>
		<div class="menu" style="border-bottom-width: 0px;">
			<input type="hidden" name="boardNumber" value="${boardNumber}">
			<input type="hidden" name="groupNumber" value="${groupNumber}">
			<input type="hidden" name="sequenceNumber" value="${sequenceNumber}">
			<input type="hidden" name="sequenceLevel" value="${sequenceLevel}"> 
			
		
		<div id="id">작성자</div>
		<span>
			<input type="text" name="name" size="12">
		</span>
		</div>
		
		<div class="menu" style="border-bottom-width: 0px;">
		<div id="id">제목</div>
		<span>
			<input type="text" name="subject" size="50">
		</span>
		</div>
		
		<div class="menu" style="border-bottom-width: 0px;">
		<div id="id">이메일</div>
		<span>
			<input type="email" name="email" size="50">
		</span>
		</div>
		
		<div class="content" style="border-bottom-width: 0px;">
		<div id="text">내용</div>
		<span>
			<textarea rows="12" cols="65" name="content" ></textarea>
		</span>
		</div>
		
		<div class="menu" style="border-bottom-width: 0px;">
		<div id="id">비밀번호</div>
		<span>
			<input type="password" name="password" size="30">
		</span>
		</div>
		
		<div class="menu" style="border-bottom-width: 3px; text-align:center;">
		<span>
			<input type="submit" value="글쓰기">
			<input type="reset" value="다시작성">
			<input type="button" value="목록보기">
		</span>
		</div>
	</form>
</body>
</html>