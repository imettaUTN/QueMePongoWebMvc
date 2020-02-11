<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> </p>
     <p><fmt:message key="login"/> </p>
    
    <br>
    
    <form:form method="post"  commandName="credential">
	    <table >
		    <tr>
			    <td>
			   	 	 <form:label path="">Nombre Usuario</form:label>
			    	 <form:input path="nombre"/>
			    </td>
			   </tr>
			    <tr>
			    <td>
			   	 	 <form:label path="">Apellido</form:label>
			    	 <form:input path="apellido"/>
			    </td>
			   </tr>
			    <tr>
			    <td>
			   	 	 <form:label path="">Email</form:label>
			    	 <form:input path="mail"/>
			    </td>
			   </tr>
			   <tr>
			    <td>
			     	 <form:label path="">password</form:label>    
			   	     <form:password  path="password"/>
			    </td>
		    </tr>
	    </table>    
    <br>
  <input type="submit" value="Execute">
</form:form>
</body>
</html>