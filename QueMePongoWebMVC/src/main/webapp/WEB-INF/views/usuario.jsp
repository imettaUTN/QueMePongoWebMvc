<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
   <title><fmt:message key="title"/></title></head>
  <style type="text/css">
  input{
    display: block;
    text-align: right;
    
}
  </style>
  <body>
  	 <div id="main" style="width: 500px; height: 1000px;background-repeat:no-repeat;background-image:url('https://www.freejpg.com.ar/image-900/22/2247/F100011234-museo_louvre_en_paris_francia.jpg')">

    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> </p>
    <br>    
   
    <form:form method="post"  commandName="UserModel">
	  
	    <table >
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
  </div>

</body>

</html>
