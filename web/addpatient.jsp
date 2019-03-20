<%-- 
    Document   : addPatient
    Created on : Dec 19, 2018, 3:39:25 PM
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
        <h3>Add Patient</h3>
        <%@include file="menu.jsp"%>
        <br/>

        <form method="post" action="Main">
            <div class="form-group">
                <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Age</label>
                    <div class="col-sm-8">
                        <input class="form-control" type="number" name="age"/>
                    </div>
                </div>
               <div class="form-group row">
                    <label class="col-sm-1 col-form-label">Group Age</label>
                    <div class="col-sm-8">
                        <select class="form-control">
                            <option value="<45" name="grupedat">menor 45</option>
                            <option value="45-49" name="grupedat">45-49</option>
                            <option value="50-54" name="grupedat">50-54</option>
                            <option value="55-59" name="grupedat">55-59</option>
                            <option value="60-64" name="grupedat">60-64</option>
                            <option value="65-69" name="grupedat">65-69</option>
                            <option value=">69" name="grupedat">mayor 69</option>
                        </select>   
                    </div>
               </div>
                
                Weight <input class="form-control" type="number" name="weight"/> 
                Height <input class="form-control" type="number" name="height"/> 
                Classification 
                <select class="form-control">
                    <option value="OSTEOPENIA" name="classification">Osteopenia</option>
                    <option value="NORMAL" name="classification">Normal</option>
                    <option value="OSTEOPOROSI" name="classification">Osteoporosi</option>               
                </select>           
                <br/>
                Manarche <input class="form-control" type="number" name="manarche"/> 
                Menpause
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
              <!--  <div class="form-check">
                    <input class="form-check-input" type="radio" name="menopause" value="NO" checked> No 
                    <input class="form-check-input" type="radio" name="menopause" value="YES"> Yes<br>
                </div>-->
              <br>
                Menopause Type 
                <select class="form-control">
                    <option value="NO CONSTA" name="menopauseType">No consta</option>
                    <option value="NATURAL" name="menopauseType">Natural</option>
                    <option value="OVARIECTOMIA" name="menopauseType">Ovariectomia</option>               
                    <option value="HISTERECTOMIA" name="menopauseType">Histerectomia</option>               
                    <option value="AMDDUES" name="menopauseType">Amb Dues</option>               
                </select>           
                <br/>
                <input class="form-control" type="submit" name="action" value="addPatient"/>
            </div>
        </form>



    </body>
</html>
