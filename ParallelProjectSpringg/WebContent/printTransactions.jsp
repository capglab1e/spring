<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix ="d" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function chkEmpty(){
	
if (document.frmReg.mobileno.value == "") {alert("Please fill the Mobile No");
	return false;}
	
	
	else {
	//alert("Hotel Booking completed Successfully.");
	return true;
		}
	}
</script>
<h1>Show Transaction</h1>
<body>
<d:form  name="frmReg" action="printdata" method="post" modelAttribute="k" onsubmit="return chkEmpty()">
<table border="2px">
<tr>
<td bgcolor="bisque">Mobile No</td>
<td><d:input path="mobileNumber" id="mobileno" pattern="[6-9][0-9]{9}"  title="Enter valid 10 digit number starting with 6 to 9"/></td>
</tr>
<tr>
<tr>
<td>
<td ><input type="Submit" value="Show Transaction"/>
</td>
</tr>
</table>
</d:form>
</body>
</html>