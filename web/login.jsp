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
       <p class='navbar navbar-expand-lg navbar-light bg-light'>Introduce your data login.</p>

        <form method="post" action="user">
            <div class="form-group">
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Username</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name="username"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Password</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name="password"/>
                    </div>
                </div>
                <input class="btn btn-default" type="submit" name="action" value="Validate"/>
                <input class="btn btn-default" type="submit" name="action" value="Back"/>
            </div>
                        
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
