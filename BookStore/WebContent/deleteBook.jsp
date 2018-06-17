<%@ page errorPage="bookerror.jsp"%>
<jsp:include page="welcome.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>Delete Book</title>
</head>
<body>
	<center>
		<h3>Delete Book</h3>
		<form action="./controller">
			<table border="1">
				<tr>
					<td>Book Id</td>
					<td><input type="text" name=bid></td>
				</tr>
				<tr>
					<td colspan="1" align="center"><input type="submit"
						name=action value="Delete"> <input type="reset"
						value="Clear"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>