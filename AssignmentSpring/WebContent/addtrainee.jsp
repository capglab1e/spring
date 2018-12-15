<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="a" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a:form action="adddata" method="post" modelAttribute="y">
<table>
<tr>
<td>Trainee Id</td>
<td><a:input path="traineeId"/></td>
</tr>
<tr>
<td>Trainee Name</td>
<td><a:input path="traineeName"/></td>
</tr>
<tr>
<td>Trainee Location</td>
<td><a:radiobutton path="traineeLocation" value="Chennai"/>Chennai
<a:radiobutton path="traineeLocation" value="Bangalore"/>Bangalore
<a:radiobutton path="traineeLocation" value="Pune"/>Pune
<a:radiobutton path="traineeLocation" value="Mumbai"/>Mumbai</td>
</tr>

<tr>
<td>Trainee Domain</td>
<td><a:select path="traineeDomain" items="${cato}"></a:select></td>
</tr>
<tr>
<td>
<input type="submit" value="Add Trainee"/>

</td>
</tr>



</a:form>
</table>
</body>
</html>