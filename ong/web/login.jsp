<%-- 
    Document   : login
    Created on : 04/10/2016, 10:24:05
    Author     : 0573159
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Casa Santa Rita - Casa do Excepcional Santa Rita de Cássia</title>
        <script> alert("login: adm\nsenha: 123")</script>
    </head>
    <body>
        <div class="login">
        <img class="center-block" id="logo" src="imagens/logo.png" alt="Logo"/>
        <p style="padding: 20px; font-weight: bold" class="text-center"> Entre para acessar o sistema.</p>
        <div class="container">
            <form method="post" action="LoginServlet">
                  
                <div class="form-group">
                    <label class="control-label" for="nLogin">Usuário: </label>
                    <input class="form-control" id="login" type="text" name="nLogin" required>
                </div>
                <div class="form-group">
                    <label class="control-label" for="nSenha">Senha: </label>
                    <input class="form-control" id="senha" type="password" name="nSenha" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">Entrar</button>
                </div>
                <p><%if(request.getAttribute("mensagem")!=null)
                    out.print(request.getAttribute("mensagem"));%></p>
            </form>
            
        </div>
        </div>
        
    </body>
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>

</html>
