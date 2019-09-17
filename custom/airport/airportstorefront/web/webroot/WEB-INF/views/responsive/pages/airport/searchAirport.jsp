<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AirportList</title>
</head>
<body>
	<h1>Airport Listing</h1>
	<ul>
		<c:forEach var="airport" items="${airports}">
			<li>${airport.name}</li>
		</c:forEach>
	</ul>
</body>
</html>