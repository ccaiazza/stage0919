<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AirportList</title>
</head>
<body>
	<h1>Airport Listing: ${tag}</h1>
	<c:if test="${airports.size()>0}">
		<table border=1>
			<tr>
				<td>Name</td>
				<td>City</td>
				<td>Country</td>
			</tr>
			<c:forEach var="airport" items="${airports}">
				<td>${airport.name}</td>
				<td>${airport.city}</td>
				<td>${airport.country}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${airports.size()==0}">
		List is Empty
	</c:if>
</body>
</html>