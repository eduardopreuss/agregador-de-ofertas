<%-- 
    Document   : listarDoacao
    Created on : Oct 5, 2016, 7:41:54 PM
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <title>Lista de Doações</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="col-md-9">
            <h1>Lista de doações</h1>
            <a class="btn btn-sm btn-default" href='DoacaoServlet?acao=Cadastro'>Cadastrar uma nova doação</a>
            <div style="padding: 10px;">
                <div class="table-responsive">
                    <%if(request.getAttribute("mensagem")!=null)
                       out.print(request.getAttribute("mensagem"));%>
                    <table class="table">
                        <tr>
                            <th>Doador</th>
                            <th>Produto</th>
                            <th>Quantidade</th>
                            <th>Data de validade</th>
                            <th>Data da doação</th>
                            <th>Ação</th>
                        </tr>
                        <c:forEach var="doacao" items="${listaDoacao}">
                        <tr>
                            <td>${doacao.nomeDoador}</td>
                            <td>${doacao.nomeProduto}</td>
                            <td>${doacao.quantidade}</td>
                            <td>${doacao.dataVal}</td>
                            <td>${doacao.dataDoacao}</td>
                            <td>
                                <a href="DoacaoServlet?acao=Excluir&id_doacao=${doacao.id_doacao}" id="excluir-doacao" class="btn" type='button'>  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> </a> 
                                <a href="DoacaoServlet?acao=Consultar&id_doacao=${doacao.id_doacao}" id="alterar-doacao" class="btn" type='button'>  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> </a> 

                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>




        <%@include file="rodape.jsp" %>
    </body>
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>

</html>
<%}
else
response.sendRedirect("login.jsp");%> 