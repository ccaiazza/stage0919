<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Route</title>
</head>
<body>
	<h1>Route</h1>
	<ul>
		<c:if test="${route!=null}">	
			<li>${route.codeRoute}</li>
		</c:if>
	</ul>
</body>
</html>