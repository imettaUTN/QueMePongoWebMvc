<!DOCTYPE HTML>
<html>
<head>
<style>
.menuCSS3 ul {
	display: flex;
	padding: 0;
	margin: 0;
	list-style: none;
}

.menuCSS3 a {
	display: block;
	padding: 2em;
	background-color: #7F7977;
	text-decoration: none;
	color: #FEFEFE;
}

.menuCSS3 a:hover {
	background-color: #434343;
}

.menuCSS3 ul li ul {
	display: none;
}

.menuCSS3 ul li a:hover+ul, .menuCSS3 ul li ul:hover {
	display: block;
}
</style>

</head>
<body>
	<nav class="menuCSS3">
		<ul>
			<li><a href="#">Usuario</a>
				<ul>
					<li><a href="/QueMePongoWebMVC/usuario.htm">Alta Usuario</a></li>
				</ul></li>
			<li><a href="#">Guardarropa</a>
				<ul>
					<li><a href="/QueMePongoWebMVC/AltaGuardarropa.htm">Crear Guardarropa</a></li>
					<li><a href="/QueMePongoWebMVC/ListarGuardarropas.htm">Listar Guardarropas</a></li>
					<li><a href="/QueMePongoWebMVC/Prenda.htm">Prenda</a></li>
					<li><a href="/QueMePongoWebMVC/ListarPrendas.htm">Lista Prendas</a></li>
				</ul></li>
			<li><a href="#">Evento</a>
				<ul>
					<li><a href="/QueMePongoWebMVC/CargarEvento.htm">Crear
							Evento</a></li>
					<li><a href="/QueMePongoWebMVC/ListarEventos.htm">Listado
							Eventos</a></li>
				</ul></li>
		</ul>
	</nav>

</body>
</html>
