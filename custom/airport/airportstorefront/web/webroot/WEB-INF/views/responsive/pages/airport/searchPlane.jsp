<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PLANE</title>
</head>
<body>
	<h3>Plane By Code</h3>
	<c:if test="${plane!=null}">
	${plane.codePlane} - ${plane.model} - ${plane.statePlane} - ${plane.numberMaxSits} - ${plane.goods} - ${plane.airLine.name}
	</c:if>
</body>
</html>