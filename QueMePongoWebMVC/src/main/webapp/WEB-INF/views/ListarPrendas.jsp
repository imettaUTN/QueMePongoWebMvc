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
		<ins>lista Prendas:</ins>
	</h3>
	<br />
	<table>
		<tbody>
			<tr>
				<td class="text-center text-uppercase">descripcion:</td>
				<td class="text-center text-uppercase">Categoria:</td>
				<td class="text-center text-uppercase">Guardarropa:</td>
			</tr>

			<c:forEach items="${listaPrendas.listaPrendas}" var="ll">

				<tr>
					<td><input type="text" name="descripcion"
						value="${ll.descripcion}" class="form-control text-left" readonly></td>
					<td><input type="text" name="fecha"
						value="${ll.descripcionCat}"
						class="form-control text-left" readonly></td>
					<td><input type="text" name="estado"
						value="${сс.descripcionGuardarropa}"
						class="form-control text-left" readonly></td>
				</tr>
				<tr>
					<td><b><a class="text-muted"
							href="/QueMePongoWebMVC/ModificarPrenda.htm?codPrenda=${ll.codPrenda}">Modificar</a></b>
					</td>
					<td><b><a class="text-muted"
							href="/QueMePongoWebMVC/EliminarPrenda.htm?codPrenda=${ll.codPrenda}">Eliminar</a></b>
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