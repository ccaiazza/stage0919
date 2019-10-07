<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AirportList</title>
</head>
<body>
	<h1>Airport</h1>
	<ul>
		<c:if test="${airport!=null}">	
			<li>${airport.name}</li>
		</c:if>
	</ul>
</body>
</html>