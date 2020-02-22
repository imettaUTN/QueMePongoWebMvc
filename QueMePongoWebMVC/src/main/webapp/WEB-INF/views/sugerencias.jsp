<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Pricing example for Bootstrap</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/pricing/">

<!-- Bootstrap core CSS -->
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="pricing.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<div class="card-deck mb-3    text-center">
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">
						Sugerencia <small class="text-muted">1</small>
					</h3>
				</div>
				<div class="card-body">
				<h6>Guardarropas: "pp"</h6>
					<c:forEach items="${Sugerencia1.listaPrendas}" var="user"
						varStatus="tagStatus">
						<ul class="list-unstyled mt-3 mb-4">

							<li>${user.descripcion}</li>
							<li>${user.colorPrimario}</li>
							<li>${user.colorSecundario}</li>

						</ul>
					</c:forEach>
					<div>
						<b><a class="text-muted"
							href="/QueMePongoWebMVC/AceptarSugerencia.htm?codPrendas=${codPrendas1}">Aceptar</a></b>
						<b><a class="text-muted"
							href="/QueMePongoWebMVC/RechazarSugerencia.htm?codPrendas=${codPrendas1}">Rechazar</a></b>
					</div>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">
						Sugerencia <small class="text-muted">2</small>
					</h3>
					<h4>Guardarropa "ppepe"</h4>
				</div>
				<div class="card-body">
					<c:forEach items="${Sugerencia2.listaPrendas}" var="user"
						varStatus="tagStatus">
						<ul class="list-unstyled mt-3 mb-4">

							<li>${user.descripcion}</li>
							<li>${user.colorPrimario}</li>
							<li>${user.colorSecundario}</li>

						</ul>
					</c:forEach>
					<div>
						<b><a class="text-muted"
							href="/QueMePongoWebMVC/AceptarSugerencia.htm?codPrendas=${codPrendas2}">Aceptar</a></b>
						<b><a class="text-muted"
							href="/QueMePongoWebMVC/RechazarSugerencia.htm?codPrendas=${codPrendas2}">Rechazar</a></b>
					</div>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">
						Sugerencia <small class="text-muted">3</small>
					</h3>
					<h4>Guardarropa "ppepe"</h4>

				</div>
				<div class="card-body">
					<c:forEach items="${Sugerencia3.listaPrendas}" var="user"
						varStatus="tagStatus">
						<ul class="list-unstyled mt-3 mb-4">

							<li>${user.descripcion}</li>
							<li>${user.colorPrimario}</li>
							<li>${user.colorSecundario}</li>

						</ul>
					</c:forEach>
					<div>
						<b><a class="text-muted"
							href="/QueMePongoWebMVC/AceptarSugerencia.htm?codPrendas=${codPrendas3}">Aceptar</a></b>
						<b><a class="text-muted"
							href="/QueMePongoWebMVC/RechazarSugerencia.htm?codPrendas=${codPrendas3}">Rechazar</a></b>
					</div>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">
						Sugerencia <small class="text-muted">4</small>
					</h3>
					<h4>Guardarropa "ppepe"</h4>

				</div>
				<div class="card-body">
					<c:forEach items="${Sugerencia4.listaPrendas}" var="user"
						varStatus="tagStatus">
						<ul class="list-unstyled mt-3 mb-4">

							<li>${user.descripcion}</li>
							<li>${user.colorPrimario}</li>
							<li>${user.colorSecundario}</li>

						</ul>
					</c:forEach>
					<div>
						<b><a class="text-muted"
							href="/QueMePongoWebMVC/AceptarSugerencia.htm?codPrendas=${codPrendas4}">Aceptar</a></b>
						<b><a class="text-muted"
							href="/QueMePongoWebMVC/RechazarSugerencia.htm?codPrendas=${codPrendas4}">Rechazar</a></b>
					</div>
				</div>
			</div>
			<div class="card mb-4 shadow-sm">
				<div class="card-header">
					<h3 class="card-title pricing-card-title">
						Sugerencia <small class="text-muted">5</small>
					</h3>
					<h4>Guardarropa "ppepe"</h4>

				</div>
				<div class="card-body">
					<c:forEach items="${Sugerencia5.listaPrendas}" var="user"
						varStatus="tagStatus">
						<ul class="list-unstyled mt-3 mb-4">

							<li>${user.descripcion}</li>
							<li>${user.colorPrimario}</li>
							<li>${user.colorSecundario}</li>

						</ul>
					</c:forEach>
					<div>
						<b><a class="text-muted"
							href="/QueMePongoWebMVC/AceptarSugerencia.htm?codPrendas=${codPrendas5}">Aceptar</a></b>
						<b><a class="text-muted"
							href="/QueMePongoWebMVC/RechazarSugerencia.htm?codPrendas=${codPrendas5}">Rechazar</a></b>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
