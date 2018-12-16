<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Montserrat"	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="resources/css/system.css">
<title>Tasks</title>
</head>
<body>
	<header>
		<form action="addTask">
			<input type="text" name="description" placeholder="Type task here"/>
		</form>
	</header>
		
	<section>
		<ul>
			<c:forEach items="${tasks}" var="task">
				<li>${task.description}</li>
			</c:forEach>
		</ul>
	</section>
</body>
</html>