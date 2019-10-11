<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PLANE</title>
</head>
<body>
	<h1>Plane By Code</h1>
	<c:if test="${plane.codePlane!=null}">
	${plane.codePlane} - ${plane.model} - ${plane.statePlane} - ${plane.numberMaxSits} - ${plane.goods} - ${plane.airLine.name}
	</c:if>
	<c:if test="${plane.codePlane==null}">
	 Plane with codePlane: (${codePlane}) NOT FOUND
	</c:if>
</body>
</html>