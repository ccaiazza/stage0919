<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RoutesList</title>
</head>
<body>
	<h1>List of Routes: ${tag}</h1>
	<c:if test="${routes.size()>0}">
		<table border=1>
			<tr>
				<td>Code Route</td>
				<td>Airport Departure</td>
				<td>Airport Arrival</td>
			</tr>
			<tr height="15">
			</tr>
			<c:forEach var="route" items="${routes}">
				<tr>
					<td>${route.codeRoute}</td>
					<td>${route.airportDeparture.name},
						${route.airportDeparture.country}</td>
					<td>${route.airportArrival.name},
						${route.airportArrival.country}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${routes.size()==0}">
		List is Empty
		</c:if>
</body>
</html>