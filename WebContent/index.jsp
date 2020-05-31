<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search App</title>
</head>
<body>

<div align="center">
	<h1>Search App</h1>
		
	<form name="searchForm" action ="SearchServlet" method="get">
		<table>
			<tr>
				<td>Search: </td> 
				<td><input type="text" name="searchVal" value="" placeholder="enter search phrase"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="submit" value="Search"></td>
			</tr>
		</table>
	</form>	
	
</div>

</body>
</html>