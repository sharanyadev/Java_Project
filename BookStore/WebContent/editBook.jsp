<%@ page errorPage="bookerror.jsp"%>
<jsp:include page="welcome.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>Edit Book</title>
</head>
<body>
	<center>
		<h3>Edit Book</h3>
		<form action="./controller">
			<table border="1">
				<tr>
					<td>Enter Book Id which you want to Edit</td>
					<td><input type="text" name=bid></td>
				</tr>
				<tr>
					<td>Edit Name</td>
					<td><input type="text" name=bname></td>
				</tr>
				<tr>
					<td>Edit Author</td>
					<td><input type="text" name=author></td>
				</tr>
				<tr>
					<td>Edit Prize</td>
					<td><input type="text" name=prize></td>
				</tr>
				<tr>
					<td colspan="1" align="center"><input type="submit"
						name=action value="Edit"> <input type="reset"
						value="Clear"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>