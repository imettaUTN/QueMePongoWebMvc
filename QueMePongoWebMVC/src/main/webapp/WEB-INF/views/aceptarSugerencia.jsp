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
	<h1 class="text-center text-uppercase"  style="color:green">aceptación</h1>
	<br>
	<div class="container">
		<div class="card-deck mb-3    text-center">
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[0].categoria}</h3>
				</div>
				<div class="card-body">
					<ul class="list-unstyled mt-3 mb-4">
						<li class="text-left "><u>Descripcion:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].descripcion}</li>
						<li class="text-left "><u>Color Primario:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorPrimario}</li>
						<li class="text-left "><u>Color Secundario:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorSecundario}</li>
					</ul>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[1].categoria}</h3>
				</div>
				<div class="card-body">
					<ul class="list-unstyled mt-3 mb-4">
						<li class="text-left "><u>Descripcion:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].descripcion}</li>
						<li class="text-left "><u>Color Primario:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorPrimario}</li>
						<li class="text-left "><u>Color Secundario:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorSecundario}</li>
					</ul>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[2].categoria}</h3>
				</div>
				<div class="card-body">
					<ul class="list-unstyled mt-3 mb-4">
						<li class="text-left "><u>Descripcion:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].descripcion}</li>
						<li class="text-left "><u>Color Primario:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorPrimario}</li>
						<li class="text-left "><u>Color Secundario:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorSecundario}</li>
					</ul>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[3].categoria}</h3>
				</div>
				<div class="card-body">
					<ul class="list-unstyled mt-3 mb-4">
						<li class="text-left "><u>Descripcion:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].descripcion}</li>
						<li class="text-left "><u>Color Primario:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorPrimario}</li>
						<li class="text-left "><u>Color Secundario:</u></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorSecundario}</li>
					</ul>
				</div>
			</div>
		</div>


		<form:form method="post" value="/AceptarSugerencia"
			commandName="${sugerencia.listaPrendas}">
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4">
					<div class="input-group">
						<input type="submit"
							style="width: 100%; padding: 6px 10px; margin: 8px 0; box-sizing: border-box;"
							value="Aceptar" class="text-center" />
					</div>
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>