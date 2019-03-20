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
        <title>Pt1.5</title>
    </head>
    <body>
        <%
           response.sendRedirect("Main?action=loadData");        
        %>
    </body>
</html>
