<%-- 
    Document   : index
    Created on : Oct 4, 2016, 10:19:37 PM
    Author     : eduardo-pc
--%>

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
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Casa do Excepcional Santa Rita de Cássia</title>
    </head>
    <body>
        

        
        <%@include file="menu.jsp" %>
        <script type="text/javascript">



</script>


        <div class="col-md-9">
          
            <!-- ver o que vai ser colocado aqui -->
        </div>
         <%@include file="rodape.jsp" %>
    </body>
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    
</html>
<%}
else
response.sendRedirect("login.jsp");%> 