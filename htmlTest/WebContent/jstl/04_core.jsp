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
	<h3>response.sendRedirect()를 대체하는 테그!</h3>
	<c:set var="su" value="${param.su}"/>
	<c:if test="${su==1 }">
		<c:redirect url="http://www.naver.com"/>
	</c:if>
	<c:if test="${su!=1 }">
		<c:redirect url="http://www.google.com"/>
	</c:if>
	
	<h3> 내부자원 가져오기 </h3>
	
</body>
</html>