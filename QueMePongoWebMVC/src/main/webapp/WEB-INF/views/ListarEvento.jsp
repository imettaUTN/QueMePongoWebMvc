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
	<table>
		<tbody>
		<tr> <td class="text-center text-uppercase">descripcion:</td></tr>
				<tr> <td class="text-center text-uppercase">fecha:</td></tr>
		
			<c:forEach items="${eventos}" var="eventModel">

				<tr>
					<td><input type="text" name="descripcion" value="${eventModel.descripcion}"  class="form-control"></td>
				</tr>
				<tr>
					<td><input type="text" name="descripcion" value="${eventModel.fecha}"  class="form-control"></td>
				</tr>
				<tr><td> <b><a class="text-muted" href="/QueMePongoWebMVC/ProcesarEvento.htm?IdEvento=${eventModel.descripcion}">Procesar</a></b> </td></tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>