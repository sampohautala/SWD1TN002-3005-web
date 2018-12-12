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

<h3>Artist:</h3>

<h2><c:out value="${ artist.getName() }" /></h2>

<h3>Albums:</h3>
	<ul>
<c:forEach items="${ albumlist }" var="album">
	<li>
		<c:out value="${ album.getTitle() }" />
	</li>
</c:forEach>
</ul>

<br>
<a href="http://localhost:8080/RecordStore/artistlist">To Artistlist</a>
<br>
<a href="http://localhost:8080/RecordStore/album">To Albumlist</a>

</body>
</html>