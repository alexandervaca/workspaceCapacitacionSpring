<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facturas</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<hr />
	<form:form method="post" action="agregarFactura" commandName="factura">
		<table>
			<tr>
				<td><form:label path="cliente">cliente</form:label></td>
				<td><form:input path="cliente" /></td>
				<td><form:errors path="cliente" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="numero">numero</form:label></td>
				<td><form:input path="numero" /></td>
				<td><form:errors path="numero" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="monto">monto</form:label></td>
				<td><form:input path="monto" /></td>
				<td><form:errors path="monto" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="agregar facturas" /></td>
			</tr>
		</table>
	</form:form>

	<table border="1">
		<tr>
			<td>Id</td>
			<td>Cliente</td>
			<td>Numero</td>
			<td>Monto</td>
		</tr>
		<c:forEach items="${facturas}" var="factura">
			<tr>
				<td><c:out value="${factura.id}" /></td>
				<td><c:out value="${factura.cliente}" /></td>
				<td><c:out value="${factura.numero}" /></td>
				<td><c:out value="${factura.monto}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>