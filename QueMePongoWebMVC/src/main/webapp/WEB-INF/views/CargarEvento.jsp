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
	<h4 class="text-center text-uppercase">Alta evento</h4>
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
					<td class="text-center text-uppercase">tipo evento:</td>
					<td><form:select path="tipoEvt" class="form-control">
							<form:options items="${tiposEventos}" itemValue="codTipoEvento"
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
	<br/>
	<br/>
				<b><a class="text-muted" href="/QueMePongoWebMVC/menu.htm">Back</a></b>
	</div>
</body>
</html>