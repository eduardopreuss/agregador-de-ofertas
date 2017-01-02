

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
        <title>Cadastro de usuário</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="col-md-9">
            <div class="pull-left container">
        <h1>Cadastro de Usuário</h1>
        
        <form method="post" action="UsuarioServlet" onsubmit="return(validateForm());">
            <label class="control-label erro" id="mensagemErro">
                 <% if(request.getAttribute("mensagem")!= null){
                        out.print("</br>");
                        out.print(request.getAttribute("mensagem"));
                        out.print("</br></br>");
                    }
                 %>
            </label>
            <div class="form-group">
            <label class="control-label" id="usernameLabel" for='username'>Username </label> 
            <input class="form-control" value="${usuario.username}" type='text' id="username" name='username'>
            </div>
            <div class="form-group">
            <label class="control-label" id="senhaLabel"  for='senha'>Senha </label> 
            <input class="form-control" value="${usuario.senha}" type='text' id="senha" name='senha'>
            </div>
           
            <div class="form-group">
                
                <input name='acao' value='<%
                    if(request.getAttribute("usuario")==null) 
                        out.print("Incluir");    
                    else
                        out.print("Alterar");  
                %>' hidden>

                <input name='idusuario' value='${usuario.idusuario}' hidden>
                
            <input class="btn btn-default"  type='submit' value='Enviar' name='nEnviarUsuario'>
            
            <a href='UsuarioServlet?acao=Listar'> Ver Todos Usuários</a>
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


    

    var username = $('#username').val();
    var senha = $('#senha').val();
    

    var inputVal = new Array(username, senha);

    var inputMessage = new Array("username", "senha");

     $('.error').hide();

        if(inputVal[0] == ""){
            $('#usernameLabel').after('<span class="error"> Digite o ' + inputMessage[0] + '</span>');
            return false;
        } 
        
        
        if(inputVal[1] == ""){
            $('#senhaLabel').after('<span class="error"> Digite a ' + inputMessage[1] + '</span>');
            return false;
        } 
        
        

             
}   


</script>