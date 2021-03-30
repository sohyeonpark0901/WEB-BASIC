<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str1" value="Function테그를 사용해보자"></c:set>
	<c:set var="str2" value="사용"></c:set>
	<c:set var="str3" value="1,2,3,4,5,6,7,8,9,10"></c:set>
	
	<h3>${str1}</h3>
	<h3>${str2}</h3>
	<h3>${str3}</h3>
	
	<div>
		1.문자열 길이: ${fn:length(str1)}<br>
		2. 대문자 : ${fn:toUpperCase(str1)}<br>
		3. 소문자 : ${fn:toLowerCase(str1)}<br>
		4. 문자열 추출: ${fn:substring(str1,3,6)}<br>
		5. 문자열 치환 : ${fn:replace(str,'','-'}<br>
		6. 특정 문자열 위치 : ${fn:indexOf(str1,"t")}<br>
		7. 문자열1에서 문자열 2에 포함되어있는 문자열 이후 : ${fn:substringAfter(str1,str2)}<br>
		8. 문자열1에서 문자열 2에 포함되어있는 문자열 이전 : ${fn:substringBefore(str1,str2)}<br>
		9. 서식문자열 : ${fn:startsWith(str1,'Fun')}<br>
		10. 끝문자열 : ${fn:endsWith(str1,'해보자.')}<br>
		11. 문자열을 분리해서 배열로 반환
		<c:set var="array" value="${fn:split(str3,',') }"></c:set>
		<c:forEach var="i" items="${array}">
			${i}
		</c:forEach>
		<br>
		12. 문자열 합치기
		${fn:join(array,"*")}		
	</div>
</body>
</html>