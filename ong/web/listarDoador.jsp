<%-- 
    Document   : listarDoadores
    Created on : Oct 5, 2016, 7:35:27 PM
    Author     : eduardo-pc
--%>
<%@page import="entidade.Doador"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="dao" class="entidade.Doador"/>
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
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
        <title>Lista de doadores</title>
        
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="col-md-9">
        <h1>Lista de doadores</h1>
        <a class="btn btn-sm btn-default" href='cadastroDoador.jsp'>Cadastrar novo doador</a>
            <div style="padding: 10px;">
                 
                <div class="table-responsive">
                                       <%if(request.getAttribute("mensagem")!=null)
                       out.print(request.getAttribute("mensagem"));%>
        <table class="table">
    <tr>
        <th>Nome Completo</th>
        <th>Sexo</th>
        <th>Status</th>
        <th>Tipo</th>
        <th>CPF</th>
        <th>RG</th>
        <th>Email</th>
        <th>Telefone</th>
        <th>Celular</th>
        <th>CEP</th>
        <th>Endereço</th>
        <th>Número</th>
        <th>Bairro</th>
        <th>Cidade</th>
        <th>Estado</th>
        <th>Ação</th>
    </tr>
    
        <c:forEach var="doador" items="${listaDoador}" varStatus ="row">
        <tr>
            <td>${doador.nome}</td>
            <td>${doador.sexo}</td>
            <td>${doador.status}</td>
            <td>${doador.tipo}</td>
            <td>${doador.cpf}</td>
            <td>${doador.rg}</td>
            <td>${doador.email}</td>
            <td>${doador.telefone}</td>
            <td>${doador.celular}</td>
            <td>${doador.cep}</td>
            <td>${doador.endereco}</td>
            <td>${doador.numero}</td>
            <td>${doador.bairro}</td>
            <td>${doador.cidade}</td>
            <td>${doador.estado}</td>
            <td>${doador.dataNascimento}</td>
            
        <td>
             <a href="DoadorServlet?acao=Excluir&iddoador=${doador.idDoador}" id="excluir-doador" class="btn" type='button'>  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> </a> 
             <a href="DoadorServlet?acao=Consultar&iddoador=${doador.idDoador}" id="alterar-doador" class="btn" type='button'>  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> </a> 

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