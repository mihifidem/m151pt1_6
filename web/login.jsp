<%-- 
    Document   : login.jsp
    Created on : marzo/2019
    Author     : Oscar Burgos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" />

    </head>
    <body>
        <h3>Login page</h3>
        <%@include file="menu.jsp"%>
        <br/>
       <!-- Si no estás registrado, clica <a href="register.jsp">aquí</a>-->
        
        <form method="post" action="user">
            Username: <input type="text" name="username"/>
            <br/>
            Password: <input type="password" name="password" />
            <br/>
            <input type="submit" name="action" value="Validate"/>
                        
        </form>
        
        
        <%
            
           if(request.getParameter("error")!=null){
              //out.println("Usuario y/o contraseña incorrectas");
   
               String error=request.getParameter("error");
               if(error.equals("1")) out.println("Usuario y/o contraseña incorrectas");
           } 
            
            
            
            
        %>
    </body>
</html>
