<%
    if (session.getAttribute("name") != null) {
        out.println("Hello " + session.getAttribute("name"));
    }
%>
<br/>


<%    if (session.getAttribute("name") != null) {
        //out.println("<a href='login.jsp'>Login</a>");
        //out.println("<a href='register.jsp'>Register</a>");
        out.println("<nav class='navbar navbar-expand-lg navbar-light bg-light'>");
        out.println("<li class='nav-item active'>");
        out.print("<ul class='navbar-nav'>");
        out.print("<li class='nav-item active'><a class='nav-link' href='#'>Home <span class='sr-only'>(current)</span></a></li>");
        out.print("<li class='nav-item'><a class='nav-link' href='filter.jsp'>Filter</a></li>");
        out.print("<li class='nav-item'><a class='nav-link' href='addpatient.jsp'>Add Pacient</a></li>");
        if (session.getAttribute("role").equals("admin")) {
            out.print("<li class='nav-item'><a class='nav-link' href='register.jsp'>Add User</a></li>");
            out.print("<li class='nav-item'><a class='nav-link' href='deluser.jsp'>Del User</a></li>");
        }
        out.print("<li class='nav-item'><a class='nav-link' href='logout.jsp'>Logout</a></li>");
        out.print("</li> </ul> </div> </nav>");
    }
%>




