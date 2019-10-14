<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airport</title>
</head>
<body>
    <h1>Airport</h1>
    <ul>
        <c:if test="${airport.codeIATA!=null}">   
            <li>${airport.name} - ${airport.city} - ${airport.country} </li>   
        </c:if>
        <c:if test="${airport.codeIATA==null}">   
            <li>Airport with codeIata ${codeIata} not found</li>
        </c:if>
    </ul>
</body>
</html>