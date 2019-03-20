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
        <title>Register</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" />

    </head>
    <body>
        <h3>Login page</h3>
        <%@include file="menu.jsp"%>
        <br/>

        <form method="post" action="user">
            Username: <input type="text" name="username" />
            <br/>
            Password: <input type="password" name="password" />
            <br/>
            Repeat Password: <input type="password" name="repassword" />
            <br/>
            <input type="submit" name="action" value="Register"/>

        </form>
        <%            /*if(request.getParameter("error")!=null){
                String error=request.getParameter("error");
                out.println(error);
            }*/
            if (request.getAttribute("error") != null) {
                String error = (String) request.getAttribute("error");
                out.println(error);
            }


        %>
    </body>
</html>
