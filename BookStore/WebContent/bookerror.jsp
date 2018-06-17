<%@ page import="java.sql.SQLException" isErrorPage="true"%>
<<jsp:include page="welcome.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
<style type="text/css">
h2, h3 {
	color: red;
}
</style>
</head>
<body>
	<h2>Error Page</h2>
	<h3>
		<%
			if (exception instanceof ClassNotFoundException) {
		%>
		Class Not Found Exception
		<%
			} else if (exception instanceof SQLException) {
		%>
		An SQL Exception
		<%
			} else {
		%>
		Exception
		<%
			}
		%>
		occures while interactiing with database
	</h3>
	<h3>
		The Error message was
		<%
		exception.getMessage();
	%>
	</h3>
	<h3>Please try again later!</h3>
</body>
</html>