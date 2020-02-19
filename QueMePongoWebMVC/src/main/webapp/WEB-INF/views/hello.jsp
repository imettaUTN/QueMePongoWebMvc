<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
  <head>
  	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
   <title><fmt:message key="title"/></title>
  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> </p>
     <p><fmt:message key="login"/> </p>    
     <table>
     <tr><td>${nombre}</td></tr>     
     </table>
	</body>
	</html>