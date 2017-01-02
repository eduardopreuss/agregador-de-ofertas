<%-- 
    Document   : relatorios
    Created on : 26/11/2016, 19:00:09
    Author     : Clark
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <title>Relatórios</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="col-md-9">          
            
            <h1>Relatórios</h1> 
            
            <a class="btn btn-sm btn-default" href='relatorioMaioresDoadores.jsp'>Maiores Doadores</a>
            <label>Verificar as pessoas que efetuaram a maior quantidade de doações no período. </label>
            </br></br>
            <a class="btn btn-sm btn-default" href='relatorioTotalDeCadaProduto.jsp'>Quantidade Total de Cada Produto</a>
            <label> Verificar a quantidade total de um produto recebida em determinado período</label>
            </br></br>
            <a class="btn btn-sm btn-default" href='relatorioDoadoresSemDoacoesNoPeriodo.jsp'>Não Efetuaram Doação</a>
            <label>Verificar doadores que não efetuaram doações em um período. </label>
            </br>
            </br>
            
            
            <hr> 
            <a class="btn btn-sm btn-default" href='relatorioTodasAsDoacoes.jsp'>Doações</a>
            <label>Verificar todas doações em um determinado período. </label>
            </br></br>
            <a class="btn btn-sm btn-default" href='RelatorioServlet?acao=RelatorioDoacoesDoDoador'>Doações do Doador no Período</a>
            <label>Verificar todas doações de determinado doador em um período. </label>
            </br>
            </br>
            
            
            </br>
            </br>
            </br>
        </div>

        <%@include file="rodape.jsp" %>
    </body>
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>

</html>
<%}
else
response.sendRedirect("login.jsp");%> 
