<%-- 
    Document   : relatorios
    Created on : 26/11/2016, 19:00:09
    Author     : Clark
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control","no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", -1);
    new java.util.Date();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
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

        <title>Relatórios - Todas as Doações</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="col-md-9">
            <br>
            <br>
        
            <label>Lista a data da doação, nome do doador e o produto doado no período. (Período padrão 30 dias) </label>
            </br>
            </br>
            <form method="post" action="RelatorioServlet?acao=TodasAsDoacoes">
                <div class="col-md-6">
                    <div class="col-md-5">
                        <label class="control-label" id="periodoLabel" for='periodo'>Quantidade de Dias: </label>
                    </div>
                    <div class="col-md-7">
                        <input class="form-control" value="" id="periodo" type='number' name='periodo'>
                    </div>
                </div>
                </br>
                </br><br>
                <div class="col-md-offset-5">
                <a class="btn btn-sm btn-default" href='relatorios.jsp'>Voltar</a>
                <input class="btn btn-default" type='submit' value='Gerar Relatório' name='btnTodasAsDoacoes'>
                </div>
            </form>
            </br>
            <div id="ListaDeTodasAsDoacoes">
                <div style="padding: 10px;">
                    <div class="table-responsive">
                        <label class="control-label erro" id="mensagemErro">
                            <%  
                                if(request.getAttribute("mensagem")!=null)
                                    out.print(request.getAttribute("mensagem"));
                             %>
                        </label>
                        <label class="control-label resultado" id="mensagemResultado">
                            <%  
                                if(request.getAttribute("mensagemResultado")!=null)
                                    out.print(request.getAttribute("mensagemResultado"));
                             %>
                        </label>
                        <table class="table">
                            <tr>
                                <th>Data da doação</th>
                                <th>Doador</th>
                                <th>Produto</th>
                                <th>Quantidade</th>
                            </tr>
                            <c:forEach var="doacao" items="${listaDoacao}">
                                <tr>
                                    <td>${doacao.dataDoacao}</td>
                                    <td>${doacao.nomeDoador}</td>
                                    <td>${doacao.nomeProduto}</td>
                                    <td>${doacao.quantidade}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
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
