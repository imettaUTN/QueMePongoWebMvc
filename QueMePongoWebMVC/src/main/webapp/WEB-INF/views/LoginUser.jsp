<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
  <head>
  	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
   <title><fmt:message key="title"/></title>
  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
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
  
  input{
    display: block;
    text-align: right;
    
}
  </style>
  <body>
    <h1><fmt:message key="greeting"/></h1>    
    <br>
     <p><fmt:message key="login"/> </p>            
   	<c:url value="/Login/Logiar" var="destino"/>			
    <form:form method="post"  commandName="Login">
	  <table>
		<tbody>
			<tr>
			<td>Email:</td>
			<td><input type="text" name="Email" class="form-control"></td>
			<td><form:errors path="email" cssClass="campoConError"/></td>
			</tr>
	  		<tr>
			<td>Password:</td>
			<td>
		
			<input type="password" name="Password" class="form-control"></td>
			<td><form:errors path="password" cssClass="campoConError"/></td>
			</tr>
			<tr><td id="msj" style="color:red">${ErorMessage}</td></tr>
		  <tr>
		  <tr><td>&nbsp; </td></tr>
		  <tr><td><a href="/QueMePongoWebMVC/usuario.htm">Registrarme</a></td></tr>		  
		  <tr><td>&nbsp; </td></tr>
	<td colspan="3"><input type="submit" value="Execute" /></td>
	</tr>
	</tbody>
	</table>

			</form:form>    					
	</body>
	</html>