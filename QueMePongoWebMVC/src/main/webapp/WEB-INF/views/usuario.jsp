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
	<h6 class="text-center text-uppercase small">Nuevo Usuario</h6>
	<br>
	<form:form method="post" commandName="usuario">
		<table>
			<tbody>
			    <tr>
					<td class="text-center text-uppercase">codigo usuario:</td>
					<td><input type="text" name="codigoUsuario" class="form-control"></td>
					<td><form:errors path="codigoUsuario" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">Nombre:</td>
					<td><input type="text" name="Nombre" class="form-control"></td>
					<td><form:errors path="nombre" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">Apellido:</td>
					<td><input type="text" name="Apellido" class="form-control"></td>
					<td><form:errors path="apellido" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">Email:</td>
					<td><input type="text" name="mail" class="form-control"></td>
					<td><form:errors path="mail" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td class="text-center text-uppercase">Password:</td>
					<td><input type="password" name="Password"
						class="form-control"></td>
					<td><form:errors path="password" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td>Tipo usuario</td>
					<td><select name="codigoPerfil"  class="form-control">
						
							<option value="1">Administrador</option>
							<option value="2">Estándar</option>
							<option value="3">Premium</option>
							
					</select></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Execute" /></td>
				</tr>
			</tbody>
		</table>

	</form:form>
	<div>
				<b><a class="text-muted" href="/QueMePongoWebMVC/menu.htm">Back</a></b>
	</div>
</body>
</html>