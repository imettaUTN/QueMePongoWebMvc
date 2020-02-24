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
	<h1 class="text-center text-uppercase" style="color: red">rechazo</h1>
	<br>
	<div class="container">
		<div class="card-deck mb-3    text-center">
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[0].descripcionCat}</h3>
				</div>
				<div class="card-body">
					<ul class="list-unstyled mt-3 mb-4">
						<li class="text-left "><ins>Descripcion:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].descripcion}</li>
						<li class="text-left "><ins>Color Primario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorPrimario}</li>
						<li class="text-left "><ins>Color Secundario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorSecundario}</li>
					</ul>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[1].descripcionCat}</h3>
				</div>
				<div class="card-body">
					<ul class="list-unstyled mt-3 mb-4">
						<li class="text-left "><ins>Descripcion:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].descripcion}</li>
						<li class="text-left "><ins>Color Primario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorPrimario}</li>
						<li class="text-left "><ins>Color Secundario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorSecundario}</li>
					</ul>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[2].descripcionCat}</h3>
				</div>
				<div class="card-body">
					<ul class="list-unstyled mt-3 mb-4">
						<li class="text-left "><ins>Descripcion:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].descripcion}</li>
						<li class="text-left "><ins>Color Primario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorPrimario}</li>
						<li class="text-left "><ins>Color Secundario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorSecundario}</li>
					</ul>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[3].descripcionCat}</h3>
				</div>
				<div class="card-body">
					<ul class="list-unstyled mt-3 mb-4">
						<li class="text-left "><ins>Descripcion:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].descripcion}</li>
						<li class="text-left "><ins>Color Primario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorPrimario}</li>
						<li class="text-left "><ins>Color Secundario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[3].colorSecundario}</li>
					</ul>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[4].descripcionCat}</h3>
				</div>
				<div class="card-body">
					<ul class="list-unstyled mt-3 mb-4">
						<li class="text-left "><ins>Descripcion:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[4].descripcion}</li>
						<li class="text-left "><ins>Color Primario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[4].colorPrimario}</li>
						<li class="text-left "><ins>Color Secundario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[4].colorSecundario}</li>
					</ul>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[5].descripcionCat}</h3>
				</div>
				<div class="card-body">
					<ul class="list-unstyled mt-3 mb-4">
						<li class="text-left "><ins>Descripcion:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[5].descripcion}</li>
						<li class="text-left "><ins>Color Primario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[5].colorPrimario}</li>
						<li class="text-left "><ins>Color Secundario:</ins></li>
						<li class="text-left ">${sugerencia.listaPrendas[5].colorSecundario}</li>
					</ul>
				</div>
				<div class="card mb-4 shadow-sm">
					<div class="card-header">
						<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[6].descripcionCat}</h3>
					</div>
					<div class="card-body">
						<ul class="list-unstyled mt-3 mb-4">
							<li class="text-left "><ins>Descripcion:</ins></li>
							<li class="text-left ">${sugerencia.listaPrendas[6].descripcion}</li>
							<li class="text-left "><ins>Color Primario:</ins></li>
							<li class="text-left ">${sugerencia.listaPrendas[6].colorPrimario}</li>
							<li class="text-left "><ins>Color Secundario:</ins></li>
							<li class="text-left ">${sugerencia.listaPrendas6].colorSecundario}</li>
						</ul>
					</div>
				</div>
				<div class="card mb-4 shadow-sm">
					<div class="card-header">
						<h3 class="card-title pricing-card-title">${sugerencia.listaPrendas[7].descripcionCat}</h3>
					</div>
					<div class="card-body">
						<ul class="list-unstyled mt-3 mb-4">
							<li class="text-left "><ins>Descripcion:</ins></li>
							<li class="text-left ">${sugerencia.listaPrendas[7].descripcion}</li>
							<li class="text-left "><ins>Color Primario:</ins></li>
							<li class="text-left ">${sugerencia.listaPrendas[7].colorPrimario}</li>
							<li class="text-left "><ins>Color Secundario:</ins></li>
							<li class="text-left ">${sugerencia.listaPrendas[7].colorSecundario}</li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<form:form method="post" value="/RechazarSugerencia"
			commandName="${sugerencia.listaPrendas}">
			<tr>
				<td>
					<h6 class="text-left text-uppercase">Motivo rechazo:</h6>
				</td>
			</tr>
			<tr>
				<td><select name="motivoRechazo" style="width: 349px;">
						<option value="1">Combinacion de colores</option>
						<option value="2">Combinacion Prendas</option>
						<option value="3">Rechazo por Nivel Abrigo</option>
				</select></td>
			</tr>
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4">
					<div class="input-group">
						<input type="submit"
							style="width: 100%; padding: 6px 10px; margin: 8px 0; box-sizing: border-box;"
							value="Rechazar" class="btn btn-dark" />
					</div>
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>