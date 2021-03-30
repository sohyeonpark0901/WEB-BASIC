<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1px solid black' width='600' height='400' >
	<caption>*구구단*</caption>
	<%
		String color = "";
		for(int i=1;i<10;i++){
			out.print("<tr>");
			for(int j=2;j<10;j++){
				color = j % 2 == 0 ? "pink":"skyblue";
				out.print("<td bgcolor=\"" + color + "\" align=\"center\">"+j+"*"+i+"="+j*i);
			}
			out.print("</tr>");
		}
	%>
	</table>
	
	<table border='1px solid black' width='600' height='400' >
	<caption>*구구단2*</caption>
	<%
		for(int i =1;i<10;i++){
	%>
	<tr>
	<%
		for(int j=2;j<10;j++){
			color = j % 2 == 0 ? "pink":"skyblue";
		
	%>
		<td bgcolor="<%= color %>" align="center">
		<%=j+"*"+i +"=" +j*i%>
		</td>
	<%
		}
	%>
	</tr>
	<%
		}
	%>
	</table>
</body>
</html>