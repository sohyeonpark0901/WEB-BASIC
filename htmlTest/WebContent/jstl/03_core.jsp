<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>반복문 - for</h3>
	<c:forEach var="i" begin="1" end="10" step="2">
		<h3>${i }</h3>
	</c:forEach>
	<c:forEach var="i" begin="1" end="100">
		<c:set var ="tot" value="${tot+i}"></c:set>
	</c:forEach>
	<h3> 1에서 100까지의 합: ${tot}</h3>
	
	<%
		//스플릿: jsp파일 내에서 자바 명령어 사용가능
		int su = 77;
		
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("사과");
		arrayList.add("딸기");
		arrayList.add("바나나");
	%>
	<%=su %>
	<br>
	<c:set var="arrList" value="<%=arrayList %>"></c:set>
	<c:forEach var="fruit" items="${arrList}" >
		<c:out value="${fruit}"/>
	</c:forEach>
	<c:set var="city" value="서울,인천,대구,부산,광주,대전,울산"/>
	<c:forTokens var="data" items="${city}" delims=",">
		<c:out value="${data}"/>
	</c:forTokens>
	
	<form action="04_core.jsp" method="get">
		<label>수:</label>
		<input type="text" name="su">
		<input type="submit">
	</form>
</body>
</html>