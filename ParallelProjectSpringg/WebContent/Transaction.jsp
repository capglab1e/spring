<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="w" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction details</title>
</head>
<h1>Transaction Details</h1>
<body>
<Table border="2px">
<tr>
<th bgcolor="bisque">Transaction Id</th>
<th bgcolor="bisque">Transaction MobileNo</th>
<th bgcolor="bisque">Transaction Type</th>
<th bgcolor="bisque">Transaction Amount</th>
<th bgcolor="bisque">Transaction Date</th>
</tr>

<w:forEach var="tra" items="${result}">
<tr>
<td>${tra.tranId}</td>
<td>${tra.mobileNumber}</td>
<td>${tra.tranType}</td>
<td>${tra.amount}</td>
<td>${tra.tranDate}</td>

</w:forEach>
</Table>

<h2 align="center"><a href="index.jsp">Home</a></h2>
</body>
</html>