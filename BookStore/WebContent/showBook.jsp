<%@page errorPage="bookerror.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.book.dao.Book"%>
<%@page import="com.book.dao.BookStoreDAO"%>
<<jsp:include page="welcome.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>Show Book</title>
</head>
<body>
	<center>
		<h2>Book Details</h2>
		<h3>Following Results meet your search criteria</h3>
		<table>
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Prize</th>
			</tr>
			<%
				ArrayList bookList = (ArrayList) request.getAttribute("list");
				Book book = null;
				for (int i = 0; i < bookList.size(); i++) {
					book = (Book) bookList.get(i);
			%>
			<tr>
				<td><%=book.getBid()%></td>
				<td><%=book.getbName()%></td>
				<td><%=book.getAuthor()%></td>
				<td><%=book.getPrize()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>