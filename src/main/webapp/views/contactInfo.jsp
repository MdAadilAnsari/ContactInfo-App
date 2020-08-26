<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"href="CSS/stylesheet.css"/>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
	<script src="js/form-Validation.js"></script>
</head>
<body>
	<h2 align="center"><font color="red">Save Contacts Application</font></h2>
	
	<p>
		<h2><font color='green'>${successMsg}</font></h2>
	</p>
	
	<p>
		<font color='red'>${errMsg}</font>
	</p>
	<div class="container">
	<form:form action="saveContact" name = "saveContact" modelAttribute="contact" method="POST">

		<!-- <table>
			<tr> -->
				<form:hidden path="contactId"/>
				<form:label path="contactName">Contact Name</form:label>
				<input type="text" name="contactName" id="contactName" placeholder="Smith"/>
				
				<form:label path="contactEmail">Contact E-mail</form:label>
				<input type="text" name="contactEmail" id="email" placeholder="smith@deo.com"/>
				<form:label path="contactNumber">Contact Number</form:label>
				<input type="text" name="contactNumber" id="MobileNo" placeholder="9142354567"/>
				<%-- <td>Contact Name :</td>
				<td><form:input path="contactName" /></td> --%>
			<!-- </tr>

			<%-- <tr> -->
				<!-- <td>Contact Email :</td> -->
				<td><form:input path="contactEmail" /></td>
			<!-- </tr>
 --%>
			<tr> -->
				<%-- <td>Contact Number :</td>
				<td><form:input path="contactNumber" /></td>
			</tr>

			<tr> --%>
			<button type="submit">Save</button>
			<button type="reset">Reset</button>
				<!-- <td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table> -->
	</form:form>
	<a href="viewContacts"><h2>View All Contacts</h2></a>
	</div>
	
</body>
</html>