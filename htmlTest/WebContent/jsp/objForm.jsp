<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EL 내장객체이면서 HTTP 요청 파라미터(param) -->
	<h3>이름:${param.name} </h3>
	<h3>아이디: ${param.id }</h3>
	<h3>비밀번호: ${param.pwd }</h3>
	
	<!-- EL 내장객체 - JSP 저장객체(Scope)읽기 -->
	<ul>
		<li>${pageScope.aName}</li>
		<li>${requestScope.rName }</li>
		<li>${sessionScope.sName }</li>
		<li>${applicationScope.kitri }</li>
	</ul>
	
</body>
</html>