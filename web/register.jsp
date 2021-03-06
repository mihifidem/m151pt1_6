<%-- 
    Document   : register.jsp
    Created on : marzo/2019
    Author     : Oscar Burgos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>App Osteoporosi 1.6</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" />

    </head>
    <body>
        <h3>Add User</h3>
        <%@include file="menu.jsp"%>
        

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
                        <input class="form-control" type="password" name="password"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Repeat password</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="password" name="repassword"/>
                    </div>
                </div>            
                
                <input class="btn btn-default" type="submit" name="action" value="Register"/>
            </div>

        </form>
        <%          
            if (request.getAttribute("error") != null) {
                String error = (String) request.getAttribute("error");
                out.println(error);
            }


        %>
    </body>
</html>
