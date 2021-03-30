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
	<c:set var="fruit" value="apple"></c:set>
	<c:if test="${fruit=='apple'}"/>
		<h3>${fruit} </h3>
		
	<c:if test="${fruit=='apple'}"/>
		<c:out value="${fruit}" />
		
	<c:out value="안녕하세요"/>
	<c:choose>
		<c:when test="${fruit=='apple' }">
		${fruit}
		</c:when>
		<c:when test="${fruit=='banana' }">
		${fruit}
		</c:when>
		<c:when test="${fruit=='orange' }">
		${fruit}
		</c:when>
	
	
	</c:choose>
</body>
</html>