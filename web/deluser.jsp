<%-- 
    Document   : deluser.jsp
    Created on : Marzo/2019
    Author     : Oscar Burgos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" />

    </head>
    <body>
        <h3>Delete Page</h3>
        <%@include file="menu.jsp" %>
        
        <form method="post" action="user">
            Username to delete: <input type="text" name="username" required/>
            <br/>
            <input type="submit" name="action" value="Delete"/>
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
