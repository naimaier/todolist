<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Montserrat"	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<title>Login</title>
</head>
<body>
	<section>
		<h1>Login</h1>
		<form action="login" method="POST">
			<input type="text" name="email" class="input"/><br />
			<input type="password" name="password" class="input"/><br />
			<input type="submit" value="Login" class="input">
		</form>
	</section>
</body>
</html>