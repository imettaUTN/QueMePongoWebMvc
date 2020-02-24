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
	<h3 class="text-center text-uppercase"> <ins>Alta Prenda</ins></h3>
	<form:form method="post" commandName="modelo">
		<table>
			<tbody>
				<tr>
					<td class="text-center text-uppercase">descripcion:</td>
					<td><input type="text" name="descripcion" class="form-control"></td>
					<td><form:errors path="descripcion" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">color Primario:</td>
					<td><input type="text" name="colorPrimario"
						class="form-control"></td>
					<td><form:errors path="colorPrimario" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">color Secundario:</td>
					<td><input type="text" name="colorSecundario"
						class="form-control"></td>
					<td><form:errors path="colorSecundario"
							cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">guardarropa:</td>
					<td><form:select path="codigoGuardarropa" class="form-control">
							<form:options items="${guardarropas}"
								itemValue="codigoGuardarropa" itemLabel="descripcion"></form:options>
						</form:select></td>
				</tr>
				<tr>
				<td class="text-center text-uppercase">¿Cuanto me abriga?</td>
				<td class="text-center text-uppercase">Abriga Mucho</td>
				
				
				</tr>
				<tr>
					<td class="text-center text-uppercase">tipo prenda:</td>
					<td><form:select path="tipoPrenda" class="form-control">
							<form:options items="${tiposPrendas}" itemValue="CodTipoPrenda"
								itemLabel="descripcion"></form:options>
						</form:select></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" class="btn btn-dark" value="Execute" /></td>
				</tr>
			</tbody>
		</table>

	</form:form>
	<div>
				<b><a class="text-muted" href="/QueMePongoWebMVC/menu.htm">Back</a></b>
	</div>
</body>
</html>