<%-- 
    Document   : filterPatient
    Created on : Marzo/2019
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
        <h3>Filter Patient</h3>
        <%@include file="menu.jsp"%>
       
        <form method="post" action="Main">
            <div class="form-group">
                
                    <label class="col-sm-1 col-form-label" >Classification</label>
                        <select class="form-control-inline" name="classification">
                            <option value="OSTEOPENIA">Osteopenia</option>
                            <option value="NORMAL">Normal</option>
                            <option value="OSTEOPOROSI">Osteoporosi</option> 
                        </select>   
                
                    <label class="col-sm-1 col-form-label-inline">Menopause</label>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input-inline" type="radio" name="menopause" value=true >
                            <label class="form-check-label-inline" for="exampleRadios1">
                                YES
                            </label>
                        </div>
                        <div class="col-sm-1 form-check form-check-inline">
                            <input class="form-check-input-inline" type="radio" name="menopause" value=false checked="">
                            <label class="form-check-label-inline" for="exampleRadios2">
                                NO
                            </label>
                        </div>
                    
                    <label class="col-sm-2 col-form-label-inline">Menopause Type</label>
                        <select class="col-sm-2 form-control-inline" name="menopauseType">
                            <option value="NO CONSTA">No consta</option>
                            <option value="NATURAL">Natural</option>
                            <option value="OVARIECTOMIA">Ovariectomia</option>               
                            <option value="HISTERECTOMIA">Histerectomia</option>               
                            <option value="AMDDUES">Amb Dues</option> 
                        </select>   

                
                <input class="btn btn-default" type="submit" name="action" value="filterPatient"/>
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
