<%-- 
    Document   : cadastroDoacao
    Created on : Oct 5, 2016, 6:49:04 PM
    Author     : eduardo-pc
--%>

<%@page import="entidade.Produto"%>
<%@page import="entidade.Doador"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Cadastro de doação</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="col-md-9">
            <div class="pull-left container">
                <h1> <%
                    if(request.getAttribute("acao").equals("Consultar")) {
                        out.print("Alterar");
                        
                    } else {
                        out.print("Cadastrar");
                    }
                    %>
                 Doação</h1>
                <label class="control-label erro" id="mensagemErro">
                     <% if(request.getAttribute("mensagem")!= null){
                            out.print("</br>");
                            out.print(request.getAttribute("mensagem"));
                            out.print("</br></br>");
                        }
                     %>
                </label>
                
            <form method="post" action="DoacaoServlet" onsubmit="return(validateForm());">
                <div class="form-group">
                    <input name='acao' value='<%
                    if(request.getAttribute("doacao")==null) 
                        out.print("Incluir");    
                    else
                        out.print("Alterar");  
                %>' hidden>
                    <input name='id_doacao' value='${doacao.id_doacao}' hidden>


                    <label class="control-label" id="doadorLabel" for='doador'>Doador: </label>
                    
                    <select name="doador" id="doador" class="form-control">
                        <%
                            ArrayList<Doador> listaDoador = (ArrayList<Doador>) request.getAttribute("listaDoador");
                            for(Doador doador : listaDoador) {
                                
                                out.println("<option value='" + doador.getIdDoador() + "'> "+ doador.getNome()+"</option>");
                           
                            }
                        %>
                    </select>
                    
                    
                    
                    
                </div>
                <div class="form-group">
                    <label class="control-label" id="produtoLabel" for='produto'>Produto: </label>
                    <select name="produto" id="produto" class="form-control">
                        <%
                            ArrayList<Produto> listaProduto = (ArrayList<Produto>) request.getAttribute("listaProduto");
                            for(Produto produto : listaProduto) {
                                
                                out.println("<option value='" + produto.getId_produto()+ "'> "+ produto.getNome()+"</option>");
                           
                            }
                        %>
                    </select>
                </div>
                          
                
                <div class="form-group">
                    <label class="control-label" id="quantidadeLabel" for='quantidade'>Quantidade: </label>
                    <input class="form-control" value="${doacao.quantidade}" id="quantidade" type='number' name='quantidade'>
                </div>
                <div class="form-group">
                    <label class="control-label" id="dataValLabel" for='dataVal'>Data de validade do produto: </label>
                    <input class="form-control" value="${doacao.dataVal}" id="dataVal" type='date' name='dataVal'>
                </div>
                <div class="form-group">
                    <label class="control-label" id="dataDoacaoLabel" for='dataDoacao'>Data da doação: </label>
                    <input class="form-control" value="${doacao.dataDoacao}" id="dataDoacao" type='date' name='dataDoacao'><br/>
                </div>
                <div>
                    <input name='acao' value='<%
                    if(request.getAttribute("doacao")==null) 
                        out.print("Incluir");    
                    else
                        out.print("Alterar");  
                %>' hidden>
                    <input class="btn btn-default" type='submit' value='Enviar' name='nEnviarDoacao'>
                    <a href='DoacaoServlet?acao=Listar'>Ver Todas Doações</a>
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
    var dataReg = /^\d{4}-\d{1,2}-\d{1,2}$/;

    var doador = $('#idDoador').val();
    var produto = $('#produto').val();
    var quantidade = $('#quantidade').val();
    var dataValidade = $('#dataVal').val();
    var dataDoacao = $('#dataDoacao').val();

    var inputVal = new Array(doador, produto, quantidade, dataValidade, dataDoacao);

    var inputMessage = new Array("doador", "produto", "quantidade", "data de validade", "data da doação");

     $('.erro').hide();
     
        if(inputVal[0] == ""){
           $('#doadorLabel').after('<span class="erro"> Selecione o ' + inputMessage[0] + '</span>');
            return false;
        } 
      
       if(inputVal[1] == ""){
            $('#produtoLabel').after('<span class="erro"> Selecione o ' + inputMessage[1] + '</span>');
            return false;
       } 
        
        if(inputVal[2] === ""){
            $('#quantidadeLabel').after('<span class="erro"> Digite a ' + inputMessage[2] + '</span>');
            return false;
        } 
        else if(!numberReg.test(quantidade)){
            $('#quantidadeLabel').after('<span class="erro"> Digite apenas números </span>');
            return false;
        }
        
         if(inputVal[3] === ""){
            $('#dataValLabel').after('<span class="erro"> Digite a ' + inputMessage[3] + '</span>');
            return false;
        } 
        else if(!dataReg.test(dataValidade)){
            $('#dataValLabel').after('<span class="erro"> Digite uma data válida </span>');
            return false;
        }
        if(inputVal[4] === ""){
            $('#dataDoacaoLabel').after('<span class="erro"> Digite a ' + inputMessage[4] + '</span>');
            return false;
        } 
        else if(!dataReg.test(dataDoacao)){
            $('#dataDoacaoLabel').after('<span class="erro"> Digite uma data válida </span>');
            return false;
        }
        

             
}   


</script>
