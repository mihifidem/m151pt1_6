<%-- 
    Document   : index.jsp
    Created on : marzo / 2019
    Author     : obp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>App Osteoporosi 1.6</title>
    </head>
    <body>
        <h3>Filter Patient</h3>
        <%@include file="menu.jsp"%>
        <br/>
        <%@include file="filterPatient.jsp"%>

        <%
            response.sendRedirect("Main?action=filterPatient");
        %>
    </body>
</html>
