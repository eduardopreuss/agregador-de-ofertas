<%-- 
    Document   : listarProduto
    Created on : Oct 5, 2016, 7:41:23 PM
    Author     : eduardo-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    response.setHeader("Cache-Control","no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", -1);
    new java.util.Date();
    if(session.getAttribute("currentSessionUser")!=null)
    {
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <title>Lista de produtos</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="col-md-9">
            <h1>Lista de produtos</h1>
            <a class="btn btn-sm btn-default" href='cadastroProduto.jsp'>Cadastrar um novo Produto</a>
            <div style="padding: 10px;">
                <div class="table-responsive">
                    <%if(request.getAttribute("mensagem")!=null)
                       out.print(request.getAttribute("mensagem"));%>
                    <table class="table">
                        <tr>
                           <!-- <th>id</th> -->
                            <th>Produto</th>
                            <th>Tipo</th>
                            <th>Peso</th>
                            <th>Ação</th>
                        </tr>
                        <c:forEach var="produto" items="${listaProduto}">
                        <tr>
                           <!-- <td>${produto.id_produto}</td> -->
                            <td>${produto.nome}</td>
                            <td>${produto.tipo}</td>
                            <td>${produto.peso}</td>

                            <td>
                                <a href="ProdutoServlet?acao=Excluir&id_produto=${produto.id_produto}" id="excluir-produto" class="btn" type='button'>  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> </a> 
                                <a href="ProdutoServlet?acao=Consultar&id_produto=${produto.id_produto}" id="alterar-produto" class="btn" type='button'>  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> </a> 

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