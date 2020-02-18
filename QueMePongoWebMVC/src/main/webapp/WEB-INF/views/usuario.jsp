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
	<form:form method="post" commandName="Usuario">
		<table>
			<tbody>
			    <tr>
					<td>codigo usuario:</td>
					<td><input type="text" name="codigoUsuario" class="form-control"></td>
					<td><form:errors path="codigoUsuario" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td>Nombre:</td>
					<td><input type="text" name="Nombre" class="form-control"></td>
					<td><form:errors path="nombre" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td>Apellido:</td>
					<td><input type="text" name="Apellido" class="form-control"></td>
					<td><form:errors path="apellido" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="mail" class="form-control"></td>
					<td><form:errors path="mail" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="Password"
						class="form-control"></td>
					<td><form:errors path="password" cssClass="campoConError" /></td>
				</tr>
				<tr>
					<td>¿Usuario Administrador?</td>
					<td><select name="codigoPerfil">
						
							<option value="1">Administrador</option>
							<option value="2">Publico</option>
							<option value="3">Privado</option>
							
					</select></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Execute" /></td>
				</tr>
			</tbody>
		</table>

	</form:form>
</body>
</html>