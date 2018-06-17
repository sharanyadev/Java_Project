<%@page errorPage="bookerror.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.book.dao.Book"%>
<%@page import="com.book.dao.BookStoreDAO"%>
<<jsp:include page="welcome.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>Book List</title>
</head>
<body>
	<center>
		<h3>List of the Book</h3>
		<table border="5" color="Black">
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Prize</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<%
				ArrayList bookList = (ArrayList) request.getAttribute("Blist");
				Book book = null;
				for (int i = 0; i < bookList.size(); i++) {
					book = (Book) bookList.get(i);
			%>
			<tr>
				<td><%=book.getBid()%></td>
				<td><%=book.getbName()%></td>
				<td><%=book.getAuthor()%></td>
				<td><%=book.getPrize()%></td>
				<td><a href="controller?action=EditBook">Edit</a></td>
				<td><a href="controller?action=DeleteBook">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>