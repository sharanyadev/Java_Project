<%@ page errorPage="bookerror.jsp"%>
<<jsp:include page="welcome.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>Search Book</title>
<link rel="stylesheet" type="text/css" href="book.css">
</head>
<body background="white">
	<center>
		<h3>Search Book</h3>
		<form name="search" action="./controller">
			<table border="1">
				<tr>
					<td><h4>Book Name</h4></td>
					<td><input type="text" name="bname"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="action" value="Search"> <input type="reset"
						value="Clear"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>