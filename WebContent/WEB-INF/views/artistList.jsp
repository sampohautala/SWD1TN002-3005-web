<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<p>Hae artistia id:llä<p>
<form method=get action=artist>
	<input type=text name=id value="">
	<input type=submit>
</form>


<p>Kaikki artistit:<p>
	<ul>
<c:forEach items="${ artists }" var="artist">
	<li>
		<a href="/RecordStore/artist?id=${ artist.getId() }"><c:out value="${ artist.getName() }" /></a>
	</li>
</c:forEach>
</ul>

</body>
</html>