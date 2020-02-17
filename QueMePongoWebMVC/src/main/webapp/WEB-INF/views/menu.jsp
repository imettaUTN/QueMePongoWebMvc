<%@ include file="/WEB-INF/views/include.jsp" %>
<%-- Redirected because we can't set the welcome page to a virtual URL. --%>
<html>
	<head>
		<title>Menu Desplegable</title>
		<style type="text/css">
			
			* {
				margin:0px;
				padding:0px;
			}
			
			#header {
				margin:auto;
				width:500px;
				font-family:Arial, Helvetica, sans-serif;
			}
			
			ul, ol {
				list-style:none;
			}
			
			.nav > li {
				float:left;
			}
			
			.nav li a {
				background-color:#000;
				color:#fff;
				text-decoration:none;
				padding:10px 12px;
				display:block;
			}
			
			.nav li a:hover {
				background-color:#434343;
			}
			
			.nav li ul {
				display:none;
				position:absolute;
				min-width:140px;
			}
			
			.nav li:hover > ul {
				display:block;
			}
			
			.nav li ul li {
				position:relative;
			}
			
			.nav li ul li ul {
				right:-140px;
				top:0px;
			}
			
		</style>
	</head>
	<body>
		<div id="header">
			<ul class="nav">
	
				<li><a href="">Usuario</a>
				   <ul>
						<li><a href="/QueMePongoWebMVC/usuario.htm">Alta Usuario</a></li>
				   </ul>
				</li>
				<li><a href="">Guardarropa</a>
					<ul>
						<li><a href="/QueMePongoWebMVC/guardarropa.htm">Crear Prendas</a></li>
						<li><a href="">ABM Gurdarropa</a></li>						
					</ul>
				</li>
				<li><a href="">Tablas</a>
					<ul>
						<li><a href="">Prendas</a></li>
						<li><a href="">Colores</a></li>
						<li><a href="">Categoria</a></li>
					</ul>
				</li>
				<li><a href="">Evento</a>
				 <ul>
					<li><a href="">ABM Evento</a></li>
				 </ul>
				 </li>
			</ul>
		</div>
	</body>
</html>
