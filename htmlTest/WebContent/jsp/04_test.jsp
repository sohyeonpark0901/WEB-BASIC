<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="objForm.jsp" method="post">
		<label>이름</label>
		<input type="text" name="name">
		<label>아이디</label>
		<input type="text" name="id">
		<label>비밀번호</label>
		<input type="password" name="pwd">
		
		<br>
		<input type="submit" value="전송">
		<input type="reset" value="취소">
	</form>
	
	<%
		java.util.Date date = new java.util.Date();
		//내장객체
		//pageScope : 현재 페이지에서만 데이터 공유 (지역변수의 개념)
		pageContext.setAttribute("pName","apple");
		//requestScope : 요청시 데이터 공유
		request.setAttribute("rName","samsung");
		//sessionScope : 하나의 웹 어플리케이션 웹브라우저가 종료되기 전까지
		session.setAttribute("sName", "google");
		//applicationScope : 하나의 웹 어플리케이션에서 웹서버가 꺼질때까지
		application.setAttribute("kitri","KITRI");
		
		
	%>
</body>
</html>