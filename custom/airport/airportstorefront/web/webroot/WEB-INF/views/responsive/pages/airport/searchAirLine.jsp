<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AIRLINE</title>
</head>
<body>
	<h6>AirLine By Code</h6>
	<c:if test="${airLine!=null}">
	${airLine.codeAirLine} - ${airLine.name}
	</c:if>
</body>
</html>