<%-- 
    Document   : usuariologado
    Created on : 25/11/2016, 22:43:22
    Author     : Thayse
--%>

<%@page import="entidade.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control","no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", -1);
    new java.util.Date();
    if(session.getAttribute("currentSessionUser")!=null)
    {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="LogoutServlet">Logout</a>
         <center>
            <% Usuario currentUser = (Usuario)(session.getAttribute("currentSessionUser"));%>
         
            Olá <%= currentUser.getUsername() %>
         </center>

   
 
    </body>
</html>
<%}
else
response.sendRedirect("login.jsp");%> 