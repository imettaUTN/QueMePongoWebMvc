<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title><fmt:message key="title" /></title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<style type="text/css">
body {
	font-family: verdana, sans-serif;
}

span.campoConError {
	color: red;
}
</style>
</head>
<style type="text/css">
input {
	display: block;
	text-align: right;
}
</style>
<body>
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
	</p>
	<br>
	<form:form method="post" commandName="guard">
		<table>
			<tbody>
				<tr>
					<td>Guardarropa:</td>
					<td><input type="text" name="descripcion" class="form-control"></td>
					<td><form:errors path="descripcion" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td>┐Compartido?</td>
					<td><form:errors path="compartido" cssClass="campoConError"
							readonly /></td>
				<tr>
					<td colspan="3"><input type="submit" class="btn btn-dark" value="Execute" /></td>
				</tr>
			</tbody>
		</table>

	</form:form>
	<table>
		<tbody>
			<tr>
				<td class="text-center text-uppercase">descripcion:</td>
				<td class="text-center text-uppercase">Categoria:</td>
				<td class="text-center text-uppercase">Guardarropa:</td>
			</tr>

			<c:forEach items="${guard.prendasDisponibles}" var="ll">

				<tr>
					<td><input type="text" name="descripcion"
						value="${ll.descripcion}" class="form-control text-left" readonly></td>
					<td><input type="text" name="fecha"
						value="${ll.descripcionCat}"
						class="form-control text-left" readonly></td>
					<td><input type="text" name="estado"
						value="${ll.descripcionGuardarropa}"
						class="form-control text-left" readonly></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>