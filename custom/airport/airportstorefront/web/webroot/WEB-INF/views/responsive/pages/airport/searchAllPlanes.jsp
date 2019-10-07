<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PlanesList</title>
</head>
<body>
	<h1>Planes Listing</h1>
	<ul>
		<table>
		<tr>
				<td><h4>AirLine</h4></td>
				<td><h4>CodePlane</h4></td>
				<td><h4>Model</h4></td>
				<td><h4>Sits</h4></td>
				<td><h4>Goods</h4></td>
				<td><h4>StatePlane</h4></td>
			</tr>
		<c:forEach var="planes" items="${planes}">
			<tr>
				<td>${planes.airLine.codeAirLine} - ${planes.airLine.name}</td>
				<td>${planes.codePlane}</td>
				<td>${planes.model}</td>
				<td>${planes.numberMaxSits}</td>
				<td>${planes.goods}</td>
				<td>${planes.statePlane}</td>
			</tr>
		</c:forEach>
		
	</table>
	</ul>
</body>
</html>