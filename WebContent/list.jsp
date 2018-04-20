<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.javaex.vo.GuestbookVo"%>
<%
	List<GuestbookVo> list = (List<GuestbookVo>) request.getAttribute("list");
	System.out.println(list);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook/gb" method="get">
		<input type="hidden" name="a" value="add">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<br />
	<%
		for (GuestbookVo vo : list) {
	%>
	<table width=510 border=1>
		<tr>
			<td><%=vo.getNo()%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getReg_date()%></td>
			<td><a href="/guestbook/gb?a=delete&no=<%=vo.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getContent()%><br /></td>
		</tr>
	</table>
	<br />
	<%
		}
	%>
<!-- 	<table width=510 border=1> -->
<!-- 		<tr> -->
<!-- 			<td>[1]</td> -->
<!-- 			<td>황일영</td> -->
<!-- 			<td>2017-01-15</td> -->
<!-- 			<td><a href="">삭제</a></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td colspan=4>안녕하세요<br />두번째글입니다. -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
<!-- 	<br /> -->
</body>
</html>