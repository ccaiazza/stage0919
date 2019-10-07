<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AirLinesList</title>
</head>
<body>
	<h1>AirLines Listing</h1>
	<ul>
		<c:forEach var="airLine" items="${airLines}">
			<li>${airLine.codeAirLine} - ${airLine.name}</li>
		</c:forEach>
	</ul>
</body>
</html>