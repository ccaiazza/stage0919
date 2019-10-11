<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PlanesList</title>
</head>
<body>
	<h1>Planes Listing for :   ${airLine.codeAirLine} - ${airLine.name} </h1>
	<ul>
	<c:if test="${airLine.codeAirLine==null}">
	 Plane with codeAirLine: (${codeAirLine}) NOT FOUND 
	</c:if>
	
	<c:if test="${airLine.codeAirLine!=null}">

	
	
	<table>
		<tr>
				<td><h4>CodePlane</h4></td>
				<td><h4>Model</h4></td>
				<td><h4>Sits</h4></td>
				<td><h4>Goods</h4></td>
				<td><h4>StatePlane</h4></td>
			</tr>
		<c:forEach var="planes" items="${planes}">
			<tr>
				<td>${planes.codePlane}</td>
				<td>${planes.model}</td>
				<td>${planes.numberMaxSits}</td>
				<td>${planes.goods}</td>
				<td>${planes.statePlane}</td>
			</tr>
		</c:forEach>
		
	</table>
	</c:if>
	</ul>
</body>
</html>