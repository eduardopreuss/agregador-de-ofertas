<%-- 
    Document   : cadastroProduto
    Created on : Oct 5, 2016, 6:53:31 PM
    Author     : eduardo-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <title>Cadastro de produto</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="col-md-9">
            <div class="pull-left container">
        <h1>Cadastro de Produto</h1>
        
        <form method="post" action="ProdutoServlet" onsubmit="return(validateForm());">
           <%if(request.getAttribute("mensagem")!=null)
                       out.print(request.getAttribute("mensagem"));%>
            <div class="form-group">
            <label class="control-label" id="nomeLabel" for='produto'>Produto: </label> 
            <input class="form-control" value="${produto.nome}" type='text' id="nome" name='produto'>
            </div>
            <div class="form-group">
            <label class="control-label" id="tipoLabel"  for='tipo'>Tipo: </label> 
            <input class="form-control" value="${produto.tipo}" type='text' id="tipo" name='tipo'>
            </div>
            <div class="form-group">
            <label class="control-label"  id="pesoLabel"  for='peso'>Peso: </label> 
            <input class="form-control" value="${produto.peso}" type='text' id="peso" name='peso' placeholder='em gramas'>
            </div>
            <div class="form-group">
                
                <input name='acao' value='<%
                    if(request.getAttribute("produto")==null) 
                        out.print("Incluir");    
                    else
                        out.print("Alterar");  
                %>' hidden>

                <input name='id_produto' value='${produto.id_produto}' hidden>
                
            <input class="btn btn-default"  type='submit' value='Enviar' name='nEnviarProduto'>
            
            <a href='ProdutoServlet?acao=Listar'> Ver Todos Produtos</a>
            </div>
        </form>
        
        
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
<script>


function validateForm(){


    var nameReg = /^[A-Za-z]+$/;
    var floatReg = /\d[\d\,]*/;
    var numberReg =  /^[0-9]+$/;


    var nome = $('#nome').val();
    var tipo = $('#tipo').val();
    var peso = $('#peso').val();

    var inputVal = new Array(nome, tipo, peso);

    var inputMessage = new Array("nome", "tipo", "peso");

     $('.error').hide();

        if(inputVal[0] == ""){
            $('#nomeLabel').after('<span class="error"> Digite o ' + inputMessage[0] + '</span>');
            return false;
        } 
        else if(!nameReg.test(nome)){
            $('#nomeLabel').after('<span class="error"> Digite apenas letras </span>');
            return false;
        }
        
        if(inputVal[1] == ""){
            $('#tipoLabel').after('<span class="error"> Digite o ' + inputMessage[1] + '</span>');
            return false;
        } 
        
        if(inputVal[2] === ""){
            $('#pesoLabel').after('<span class="error"> Digite o ' + inputMessage[2] + '</span>');
            return false;
        } 
        else if(!floatReg.test(peso)){
            $('#pesoLabel').after('<span class="error"> Digite apenas números </span>');
            return false;
        }
        

             
}   


</script>