<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
	<!-- 	<form method="post" action="delete.jsp"> -->
	<form method="post" action="/guestbook/gb">
		<input type='hidden' name="a" value="delete"> <input
			type='hidden' name="no" value=<%=request.getParameter("no")%>>
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="확인"></td>
				<td><a href="/guestbook/gb">메인으로 돌아가기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>