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

 <form>
 	<input type="text" name="nimi" /> <input type="submit" value="L�het�" />
 	<br>
 	<c:choose>
 	
 	<c:when test ="${ param.nimi != null }" >
 		Hello <c:out value="${ param.nimi}" />
 	</c:when>
 	
 	<c:when test ="${ param.nimi == null }" >
 		Terve tuntematon!
	</c:when>
	
  </c:choose>
 
 </form>
</body>
</html>