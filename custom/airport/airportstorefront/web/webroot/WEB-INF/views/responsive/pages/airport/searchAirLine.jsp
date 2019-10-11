<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AIRLINE</title>
</head>
<body>
	<h1>AirLine By Code</h1>
	<c:if test="${airLine.codeAirLine!=null}">
	${airLine.codeAirLine} - ${airLine.name}
	</c:if>
	
	<c:if test="${airLine.codeAirLine==null}">
	 AirLine with codeAirLine: (${codeAirLine}) NOT FOUND
	</c:if>
	
</body>
</html>