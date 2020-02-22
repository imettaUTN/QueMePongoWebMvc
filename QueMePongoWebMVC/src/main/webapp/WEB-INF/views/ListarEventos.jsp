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
	<h3  class="text-left text-uppercase"><ins>lista evento:</ins></h3>
	<br/>
	<table>
		<tbody>
		<tr> <td class="text-center text-uppercase">descripcion:</td>
				 <td class="text-center text-uppercase">fecha:</td>
				  <td class="text-center text-uppercase">estado:</td>
				 </tr>
		
			<c:forEach items="${eventos.listaPrendas}" var="eventModel">

				<tr>
					<td><input type="text" name="descripcion" value="${eventModel.descripcion}"  class="form-control text-left"></td>
					<td><input type="text" name="fecha" value="${eventModel.fecha}"  class="form-control text-left" style="width:100px;"></td>
					<td><input type="text" name="estado"  value="${eventModel.estado}"  class="form-control text-left" style="width:100px;"></td>
					</tr>
					<tr>
					<c:if test="${eventModel.estado != 'Procesado'}">
					
					<td> <b><a class="text-muted" href="/QueMePongoWebMVC/ProcesarEvento.htm?IdEvento=${eventModel.codEvento}">Procesar</a></b> </td>
					</c:if>
				</tr>
			
			</c:forEach>
		</tbody>
	</table>

</body>
</html>