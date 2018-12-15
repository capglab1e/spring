<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="d"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<d:form action="updatesuccess" method="post" modelAttribute="up">
Trainee Id:<d:input path="traineeId"/><br/>
Trainee Name:<d:input path="traineeName"/><br/>
Trainee Domain:<d:input path="traineeDomain"/><br/>
<input type="submit" value="Update Records"/>

</d:form>
</body>
</html>