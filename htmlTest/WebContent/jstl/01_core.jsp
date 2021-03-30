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
	<%-- JSTL은 JAVA를 테그로 미리 만들어 놓은 것 --%>
	<%-- 변수를 생성하고 값을 넣는것을 c:set(jstl)을 사용하고
		뽑아내는 것을 el로 이용한다. --%>
	<h3>변수 선언!</h3>
	<c:set var="su" value="10" />
	<c:set var="imsi" value="${20}" />
	
	<h3>${su} / ${imsi} </h3>
	<c:set var="msg" value="${'Hi'}" scope="page"/> <!-- page(default),request,session,application -->
	
	<c:set var="age" value="31"/>
	<div>
		메세지: ${msg}
		나이 : ${age}
	</div>
	
	<jsp:useBean id="member" class="com.java.el.memberInfo"></jsp:useBean>
	<c:set target="${member}" property="name" value="박소현"/>
	<c:set target="${member}" property="id" value="park"/>
	<c:set target="${member}" property="pwd" value="111"/>
	
	<h3>${member.name }</h3>
	<h3>${member.id }</h3>
	<h3>${member.pwd }</h3>
	
	<%-- session.setAttribute --%>
	<c:set var="id" value="${member.id}" scope="session"/>
	<h3> ${sessionScope.id } ,${id}</h3>
	
	
	
</body>
</html>