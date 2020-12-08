<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>

	<!-- if errors exist, show them -->
	<p><c:out value="${error}"/></p>
	
	<form method="POST" action="/">
		<label>What is the code?</label>
		<input type="text" name="code_input"/>
		<button>Try Code</button>
	</form>
	
	<a href="/clear">Clear session</a>

</body>
</html>