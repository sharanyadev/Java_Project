<%@ page errorPage="bookerror.jsp"%>
<jsp:include page="welcome.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>Add Book</title>
<link rel="stylesheet" type="text/css" href="book.css">
</head>
<body background="white">
	<center>
		<h2>Add Book</h2>
		<form name="Save" action="controller">
			<table border="1">
				<tr>
					<td><h4>Book Name</h4></td>
					<td><input type="text" name="bname"></td>
				</tr>
				<tr>
					<td><h4>Book Author</h4></td>
					<td><input type="text" name="author"></td>
				</tr>
				<tr>
				<tr>
					<td><h4>Prize</h4></td>
					<td><input type="text" name="prize"></td>
				</tr>
				<td colspan="2" align="center"><input type="submit"
					name="action" value="Save" /> <input type="reset" value="Clear">
				</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>