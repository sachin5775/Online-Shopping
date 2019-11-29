<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of All Order</h1>


	<table border="1">
	
		<tr>

			<td>OrderId = ${orderList.order_id}
			<br>
			<%-- UserName :- ${orderList.UserName} --%></td>
			
			<td> Order Date = ${orderList.date}</td>
		</tr>
	
	
		<tr>
		<th>addToCartId</th>
		<th>ProductId</th>
		<th>Total</th>
		<th>Quantity</th>	
		</tr>
		
		<c:forEach items="${orderList.addToCartsList}" var="addToCart">
		<tr>
		<td>${addToCart.add_To_Cart_id}</td>
		<td>${addToCart.product_id}</td>
		<td>${addToCart.total}</td>
		<td>${addToCart.quantity}</td>
		</tr>
		</c:forEach>
		
		<tr>
			<th>Total Price :- ${orderList.price}</th>
		</tr>

		
	</table>
</body>
</html>