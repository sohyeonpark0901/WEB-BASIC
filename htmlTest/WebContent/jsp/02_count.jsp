<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
int cnt;
public void init(){
	cnt = 0;
}
%>
<%
	cnt++;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>방문을 환영합니다</h3>
		당신은 <%=cnt %>번째 방문자 입니다.
		
	
	</div>
</body>
</html>