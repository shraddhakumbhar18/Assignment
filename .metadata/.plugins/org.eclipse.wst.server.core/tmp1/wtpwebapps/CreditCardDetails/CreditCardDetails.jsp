<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Credit Card Details</h2>
	<table border="1">
		<tr>
			<th>Card Name</th>
			<th>Card Number</th>
			<th>CVV</th>
			<th>Credit Limit</th>
		</tr>
		<tr>
			<td>${customerName}</td>
			<td>${CardNumber}</td>
			<td>${CVV}</td>
			<td>${CreditLimit}</td>
		</tr>

	</table>
</body>
</html>