<%-- 
    Document   : viewpatients.jsp
    Created on : marzo/2019
    Author     : Oscar Burgos
--%>

<%@page import="model.Patient"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" />
        <title>App Osteoporosis</title>
    </head>
    <body>
        <h3>Initial page</h3>
        <br/>
        <%
            if (session.getAttribute("name") == null) {
                out.println("<nav class='navbar navbar-expand-lg navbar-light bg-light'>");
                out.println("<li class='nav-item active'>");
                out.print("<ul class='navbar-nav'>");
                out.print("<li class='nav-item active'><a class='nav-link' href='login.jsp'>Login <span class='sr-only'>(current)</span></a></li>");          
                out.print("</li> </ul> </div> </nav>");
                //out.println("<a class='nav-link' href='login.jsp'>Login</a>");
                //out.println("<a href='register.jsp'>Register</a>");
                if (request.getAttribute("listObjPatients") != null) {
                    List<Patient> patients = (List<Patient>) request.getAttribute("listObjPatients");
                    StringBuilder dynamicTable = new StringBuilder("");
                    dynamicTable.append(""
                            + "<table class='table'>"
                            + "<thead class='thead-dark'>"
                            + "<tr>"
                            + "<th scope='col'>Age Group</th>"
                            + "<th scope='col'>Weight</th>"
                            + "<th scope='col'>IMC</th>"
                            + "<th scope='col'>Classification</th>"
                            + "</tr></thead><tbody>");
                    for (Patient p : patients) {
                        //out.println("<br/>"+p.toString());
                        dynamicTable.append(String.format("<tr>"
                                + "<td scope='row'>%s</td>"
                                + "<td>%d</td><td>%.2f</td><td>%s</td></tr>",
                                p.getGrupEdat(), p.getWeight(),
                                p.getImc(), p.getClassification()));

                    }
                    out.println(dynamicTable.toString());

                }
            } else {
                %>
                <%@include file="menu.jsp"%>

               <%
                if (request.getAttribute("listObjPatients") != null) {
                    List<Patient> patients = (List<Patient>) request.getAttribute("listObjPatients");
                    StringBuilder dynamicTable = new StringBuilder("");
                    dynamicTable.append("<table class='table'><thead class='thead-dark'>"
                            + "<tr><th scope='col'>Age</th>"
                            + "<th scope='col'>Group Age</th>"
                            + "<th scope='col'>Weight</th>"
                            + "<th scope='col'>Height</th>"
                            + "<th scope='col'>IMC</th>"
                            + "<th scope='col'>Classification</th>"
                            + "<th scope='col'>Manarche</th>"
                            + "<th scope='col'>Menopause</th>"
                            + "<th scope='col'>Menopause Type</th>"
                            + "</tr></thead><tbody>");
                    for (Patient p : patients) {
                        //out.println("<br/>"+p.toString());
                        dynamicTable.append(String.format("<tr>"
                                + "<td scope='row'>%d</td>"
                                + "<td>%s</td>"
                                + "<td>%d</td>"
                                + "<td>%d</td>"
                                + "<td>%.2f</td>"
                                + "<td>%s</td>"
                                + "<td>%d</td>"
                                + "<td>%b</td>"
                                + "<td>%s</td>"
                                + "</tr>",
                                p.getAge(), p.getGrupEdat(),
                                p.getWeight(), p.getHeight(), p.getImc(),
                                p.getClassification(),
                                p.getManarche(), p.getMenopause(),p.getMenopauseType()));

                    }
                    out.println(dynamicTable.toString());

                }
            }

        %>




    </body>
</html>
