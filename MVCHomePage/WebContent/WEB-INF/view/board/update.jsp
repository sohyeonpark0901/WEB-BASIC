<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/board/boardStyle.css"/>
<script type="text/javascript" src="${root}/javascript/board/board.js"></script>
</head>
<body>
		<form id="createform" name="createform" action="${root}/board/updateOk.do" method="post">
			
			<div class="menu" style="border-bottom-width: 0px;display:none;" >
				<div id="id">게시물번호</div>
				<span>
					<input type="text" name="boardNumber" size="12" value="${boardDto.boardNumber}">
				</span>
				
			</div>
			
			<div class="menu" style="border-bottom-width: 0px;display:none;" >
				<div id="id">페이지번호</div>
				<span>
					<input type="text" name="pageNumber" size="12" value="${pageNumber}">
				</span>
				
			</div>
			
			<div class="menu" style="border-bottom-width: 0px;">
				<div id="id">작성자</div>
				${boardDto.writer}
			</div>
				
			<div class="menu" style="border-bottom-width: 0px;">
				<div id="id">제목</div>
				<span>
					<input type="text" name="subject" size="12" value="${boardDto.subject}">
				</span>
			</div>
			
			<div class="menu" style="border-bottom-width: 0px;">
				<div id="id">이메일</div>
				<span>
					<input type="email" name="email" size="12" value="${boardDto.email}">
				</span>
			</div>
			
			<div class="content" style="border-bottom-width: 0px;">
				<div id="text">내용</div>
				<span>
					<textarea name="content" rows="12" cols="65">${boardDto.content}</textarea>
				</span>
				
			</div>
			
			<div class="menu" style="border-bottom-width: 0px;">
				<div id="id">비밀번호</div>
				<span>
					<input type="password" name="password" size="12" value="${boardDto.password}">
				</span>
			</div>
			
			<div class="menu" style="border-bottom-width:3px; text-align:center;">
				<span> 
					<input type="submit" value="수정완료" />
			 		<input type="reset" value="취소" />
				</span>
			
			</div>
		</form>

</body>
</html>