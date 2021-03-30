<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>숫자를 문자열로 변환</h3>
	number:
		<fmt:formatNumber value="12345.678" type="number"/><br>
	currency:
		<fmt:formatNumber value="12345.678" type="currency"/>
		<fmt:formatNumber value="12345.678" type="currency" currencySymbol="$"/>
	percent
		<fmt:formatNumber  value="12345.678" pattern=".00000"/>
	<h3>문자열로 변환</h3>
	<c:set var="str" value="${'1000'}"></c:set>	
	<fmt:parseNumber var="pNum" value="${str}"/>
	<fmt:parseNumber var="isu" value="55.7" integerOnly="true"/>
	${isu}
	<h3>날짜를 문자열로 변환</h3>
	<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
	<c:set var="today" value="${date}"/>
	현재날짜(날짜형식): ${today}<br>
	변환날짜 : <fmt:formatDate value="${date}" type="date"/>
	변환날짜 : <fmt:formatDate value="${date}" type="time"/>
	변환날짜 : <fmt:formatDate value="${date}" type="both" dateStyle="short" timeStyle="short"/>
	
	날짜패턴: <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
	
	<h3>문자열 날짜 변환</h3>
	<c:set var="nowDate" value="2021-03-15 17:13:30"/>
	<fmt:parseDate  value="${nowDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
		
</body>
</html>