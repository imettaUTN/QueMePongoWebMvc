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
	<h3 class="text-left text-uppercase">
		<ins>lista guardarropa:</ins>
	</h3>
	<br />
	<table>
		<tbody>
			<tr>
				<td class="text-center text-uppercase">descripcion:</td>

			</tr>

			<c:forEach items="${Lguarda.listaGuardarropa}" var="eventModel">

				<tr>
					<td><input type="text" name="descripcion"
						value="${eventModel.descripcion}" class="form-control text-left"></td>
				</tr>
				<tr>
					<td><b><a class="text-muted"
							href="/QueMePongoWebMVC/ModificarGuardarropa.htm?codGuard=${eventModel.id}">Modificar</a></b>    
					</td>
					<td><b><a class="text-muted"
							href="/QueMePongoWebMVC/codGuard.htm?codGuard=${eventModel.id}">Eliminar</a></b>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
<div>
				<b><a class="text-muted" href="/QueMePongoWebMVC/menu.htm">Back</a></b>
	</div>
</body>
</html>