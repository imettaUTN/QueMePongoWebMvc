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
	<form:form method="post" value="/CargarEvento" commandName="evento">
		<table>
			<tbody>
			    <tr>
					<td class="text-center text-uppercase">descripcion:</td>
					<td><input type="text" name="descripcion" class="form-control"></td>
					<td><form:errors path="descripcion" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">Fecha evento:</td>
					<td><input type="text" name="fecha" class="form-control"></td>
					<td><form:errors path="fecha" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">temperatura Minima:</td>
					<td><input type="text" name="temperaturaMinima" class="form-control"></td>
					<td><form:errors path="temperaturaMinima" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">temperatura Maxima:</td>
					<td><input type="text" name="temperaturaMaxima" class="form-control"></td>
					<td><form:errors path="temperaturaMaxima" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">latitud:</td>
					<td><input type="text" name="latitud"
						class="form-control"></td>
					<td><form:errors path="latitud" cssClass="campoConError" /></td>
				</tr>
					<tr>
					<td class="text-center text-uppercase">longitud:</td>
					<td><input type="text" name="longitud"
						class="form-control"></td>
					<td><form:errors path="longitud" cssClass="campoConError" /></td>
				</tr>
					<tr >
					<td class="text-center text-uppercase">frecuencia:</td>
					<td><input type="text" name="frecuencia"
						class="form-control"></td>
					<td><form:errors path="longitud" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Execute" /></td>
				</tr>
			</tbody>
		</table>

	</form:form>
</body>
</html>