<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="a"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Create A New Account</h1>
<body>
<script type="text/javascript">
function chkEmpty(){
	
	
if (document.frmReg.name.value == "") {alert("Please fill the Name");
return false;
}
	else if (document.frmReg.mobileno.value == "") {alert("Please fill the Mobile No");
	return false;}
	
	
	else {
	//alert("Hotel Booking completed Successfully.");
	return true;
		}
	}
</script>


<a:form name="frmReg" action="adddata" method="post" modelAttribute="y" onsubmit="return chkEmpty()">
<table border="2px">

<tr>
<td bgcolor="bisque">Name</td>
<td><a:input path="name" id="name" pattern="[A-Z][a-z]{0,19}" title="Enter first letter Capital"/></td>
</tr>

<tr>
<td bgcolor="bisque">Mobile No</td>
<td><a:input path="mobileno" id="mobileno"  pattern="[6-9][0-9]{9}"  title="Enter valid 10 digit number starting with 6 to 9"/></td>
</tr>

<tr>
<td bgcolor="bisque">Initial Balance</td>
<td><a:input path="bal"/></td>
</tr>

<tr>
<td>
<td><input type="submit" value="Add User"/>
</td>
</tr>
</table>
</a:form>

</body>
</html>