<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Email Id</th><th>Name</th><th>Salary</th><th>City</th></tr>  
     <c:forEach var="driver" items="${driverList}">
   <tr>  
   <td>${driver.email}</td>  
   <td>${driver.name}</td>  
   <td>${driver.salary}</td>  
   <td>${driver.city}</td>  
   </tr>  
  </c:forEach>
   </table>
</body>
</html>