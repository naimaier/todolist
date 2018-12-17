<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Montserrat"	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="resources/css/system.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<title>Tasks</title>
</head>
<body>
	<header>
		<form action="addTask" method="POST">
			<input type="text" name="description" placeholder="Type task here"/>
		</form>
	</header>
		
	<section>
		<ul>
			<c:forEach items="${tasks}" var="task">
				<li><input type="checkbox" id="finished_${task.id}" name="finished" ${task.finished ? 'checked' : ''}><label for="finished_${task.id}">${task.description}</label><i class="far fa-trash-alt"></i></li>
			</c:forEach>
		</ul>
	</section>
</body>
</html>