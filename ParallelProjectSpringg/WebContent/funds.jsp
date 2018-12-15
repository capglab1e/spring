<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="p" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  <script type="text/javascript">
function chkEmpty(){
	
	
if (document.frmReg.mobileno.value == "") {alert("Please fill the Mobile No");
return false;
}
	else if (document.frmReg.mobileno.value == "") {alert("Please fill the Mobile No");
	return false;}
	
	
	else {
	//alert("Hotel Booking completed Successfully.");
	return true;
		}
	}
</script>-->

<h1>Fund Transfer</h1>
<body>
<p:form action="fundata" method="post" modelAttribute="s">
<table border="2px">
<tr>
<td bgcolor="bisque">Source Mobile No</td>
<td><p:input path="mobileno" /></td>
</tr>
<tr>
<td bgcolor="bisque">Target Mobile No</td>
<td><p:input path="mobileno" /></td>
</tr>
<tr>
<td bgcolor="bisque">Transfer Amount</td>
<td><p:input path="bal"/></td>
</tr>

<tr>
<td>
<td align="right"><input type="Submit" value="Deposit Amt"/>
</td>
</tr>
</table>
</p:form>
</body>
</html>