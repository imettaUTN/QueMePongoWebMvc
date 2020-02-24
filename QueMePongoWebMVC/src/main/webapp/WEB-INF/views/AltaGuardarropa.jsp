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
				<c:if test="${codPerfil == 3}"> 			
				<tr>
					<td>¿Compartido?</td>
					<td><select name="compartido">
							<option value="true">Si</option>
							<option value="false">No</option>
					</select></td>
				</tr>
				</c:if>
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