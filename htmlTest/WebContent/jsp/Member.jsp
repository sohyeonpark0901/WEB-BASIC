<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="com.java.el.memberInfo">
${member.setName("박소현")}
${member.setId("shg5865")}
${member.setPwd("1234")}
</jsp:useBean>
<h3>${member.getName()}</h3>
<h3>${member.getId()}</h3>
<h3>${member.getPwd()}</h3>

<h3>${member.name}</h3>
<h3>${member.id}</h3>
<h3>${member.pwd}</h3>
</body>
</html>