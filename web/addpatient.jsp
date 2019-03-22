<%-- 
    Document   : addPatient
    Created on : Marzo/2019
    Author     : Oscar Burgos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>App Osteoposis 1.6</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" />

    </head>
    <body>
        <h3>Add Patient</h3>
        <%@include file="menu.jsp"%>

        <form method="post" action="Main">
            <div class="form-group">
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Age</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="number" name="age" min="1" max="120"/>
                    </div>
                </div> 
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Group Age</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="grupedat">
                            <option value="<45">menor 45</option>
                            <option value="45-49">45-49</option>
                            <option value="50-54">50-54</option>
                            <option value="55-59">55-59</option>
                            <option value="60-64">60-64</option>
                            <option value="65-69">65-69</option>
                            <option value=">69">mayor 69</option>
                        </select>   
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Weight</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="number" name="weight" min="10" max="150" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Height</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="number" name="height" min="30" max="210" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label" >Classification</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="classification">
                            <option value="OSTEOPENIA">Osteopenia</option>
                            <option value="NORMAL">Normal</option>
                            <option value="OSTEOPOROSI">Osteoporosi</option> 
                        </select>   
                    </div>
                </div>        
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Manarche</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="number" name="manarche" min="5" max="18"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Menopause</label>
                    <div class="col-sm-3">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="menopause" value=true >
                            <label class="form-check-label" for="exampleRadios1">
                                YES
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="menopause" value=false checked="">
                            <label class="form-check-label" for="exampleRadios2">
                                NO
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Menopause Type</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="menopauseType">
                            <option value="NO CONSTA">No consta</option>
                            <option value="NATURAL">Natural</option>
                            <option value="OVARIECTOMIA">Ovariectomia</option>               
                            <option value="HISTERECTOMIA">Histerectomia</option>               
                            <option value="AMDDUES">Amb Dues</option> 
                        </select>   
                    </div>
                </div>     

                
                <input class="btn btn-default" type="submit" name="action" value="addPatient"/>
            </div>
        </form>
<%
            
           if(request.getParameter("error")!=null){
              //out.println("Usuario y/o contraseña incorrectas");
   
               String error=request.getParameter("error");
               out.println(error);
           } 
            
            
            
            
        %>


    </body>
</html>
