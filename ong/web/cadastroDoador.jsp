<%-- 
    Document   : cadastro
    Created on : Oct 4, 2016, 10:35:37 PM
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



        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
         <!-- <script type="text/javascript">
                
                    function validateForm() {


                        var nameReg = /^[A-Za-z]+$/;
                        var numberReg = /^[0-9]+$/;
                        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
                        var dataReg = /^\d{4}-\d{1,2}-\d{1,2}$/;
                        var cpfReg = /^(([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})|([0-9]{11}))$/;
                        var rgReg = /[0-9][0-9.]*[0-9]/;
                        var telefoneReg = /^[0-9]+$/;
                        var celularReg = /^[0-9]+$/;
                        var cepReg = /\d{5}-\d{3}/;


                        var nome = $('#nome').val();
                        var dataNasc = $('#dataNasc').val();
                        var cpf = $('#cpf').val();
                        var rg = $('#rg').val();
                        var telefone = $('#telefone').val();
                        var celular = $('#celular').val();
                        var cep = $('#cep').val();
                        var email = $('#email').val();

                        var inputVal = new Array(nome, dataNasc, cpf, rg, telefone, celular, cep, email);

                        var inputMessage = new Array("nome", "data de nascimento", "cpf", "rg", "telefone", "celular", "cep", "email");

                        $('.error').hide();

                        if (inputVal[0] == "") {
                            $('#nomeLabel').after('<span class="error"> Insira o ' + inputMessage[0] + '</span>');
                            return false;
                        } else if (!nameReg.test(nome)) {
                            $('#nomeLabel').after('<span class="error"> Insira apenas letras </span>');
                            return false;
                        }

                        if (inputVal[1] == "") {
                            $('#dataNascLabel').after('<span class="error"> Insira a ' + inputMessage[1] + '</span>');
                            return false;
                        } else if (!dataReg.test(dataNasc)) {
                            $('#dataNascLabel').after('<span class="error"> Insira uma ' + inputMessage[1] + ' válida </span>');
                            return false;
                        }

                        if (inputVal[2] === "") {
                            $('#cpfLabel').after('<span class="error"> Insira o ' + inputMessage[2] + '</span>');
                            return false;
                        } else if (!cpfReg.test(cpf)) {
                            $('#cpfLabel').after('<span class="error"> Insira um ' + inputMessage[2] + 'válido </span>');
                            return false;
                        }

                        if (inputVal[2] === "") {
                            $('#rgLabel').after('<span class="error"> Insira o ' + inputMessage[3] + '</span>');
                            return false;
                        } else if (!rgReg.test(rg)) {
                            $('#rgLabel').after('<span class="error"> Insira um ' + inputMessage[3] + 'válido </span>');
                            return false;
                        }
                        if (inputVal[4] === "") {
                            $('#telefoneLabel').after('<span class="error"> Insira o ' + inputMessage[4] + '</span>');
                            return false;
                        } else if (!telefoneReg.test(telefone)) {
                            $('#telefoneLabel').after('<span class="error"> Insira um ' + inputMessage[4] + 'válido </span>');
                            return false;
                        }
                        if (inputVal[5] === "") {
                            $('#celularLabel').after('<span class="error"> Insira o ' + inputMessage[5] + '</span>');
                            return false;
                        } else if (!celularReg.test(celular)) {
                            $('#celularLabel').after('<span class="error"> Insira um ' + inputMessage[5] + 'válido </span>');
                            return false;
                        }
                        if (inputVal[6] === "") {
                            $('#cepLabel').after('<span class="error"> Insira o ' + inputMessage[6] + '</span>');
                            return false;
                        } else if (!cepReg.test(cep)) {
                            $('#cepReg').after('<span class="error"> Insira um ' + inputMessage[6] + 'válido </span>');
                            return false;
                        }
                        if (inputVal[7] === "") {
                            $('#emailLabel').after('<span class="error"> Insira o ' + inputMessage[7] + '</span>');
                            return false;
                        } else if (!emailReg.test(email)) {
                            $('#emailLabel').after('<span class="error"> Insira um ' + inputMessage[7] + 'válido </span>');
                            return false;
                        }



                    }


               
    </script>-->
         
         

        <title>Cadastro de doadores</title>
    </head>
    <body>

        <%@include file="menu.jsp" %>
        <div class="col-md-9">
            <div style="max-width: 1000px" class="pull-left container">
                <h1>Cadastro de doadores</h1>
                <form method="post" action="DoadorServlet" onsubmit="return(validateForm());">
                    <%if(request.getAttribute("mensagem")!=null)
                       out.print(request.getAttribute("mensagem"));%>
                    <!--COLUNA 1-->
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label" id="nomeLabel" for="nome">Nome Completo: </label>
                            <input class="form-control" value='${doador.nome}' id="nome" type="text" name="nome">
                        </div>
                        <div class="form-group">
                            Sexo: 
                            <label class="radio-inline">
                                <input type='radio' name='sexo' value='Masculino'  <c:if test="${doador.sexo=='Masculino'}">checked</c:if>> Masculino  
                            </label>
                            <label class="radio-inline">
                                <input type='radio' name='sexo' value='Feminino' <c:if test="${doador.sexo=='Feminino'}">checked</c:if> > Feminino
                            </label>
                        </div>
                        <div class="form-group">
                            Status: 
                            <label class="radio-inline">
                                <input type='radio' name='status' value='Ativo' <c:if test="${doador.status=='Ativo'}">checked</c:if>> Ativo
                            </label>
                            <label class="radio-inline">
                                <input type='radio' name='status' value='Inativo' <c:if test="${doador.status=='Inativo'}">checked</c:if>> Inativo
                            </label>
                            
                        </div>
                        <div class="form-group">
                            Tipo: 
                            <label class="radio-inline">
                                <input type='radio' name='tipo' value='Pessoa Fisica' <c:if test="${doador.tipo=='Pessoa Fisica'}">checked</c:if> >Pessoa Física
                            </label>
                            <label class="radio-inline">
                                <input  type='radio' name='tipo' value='Pessoa Juridica' <c:if test="${doador.tipo=='Pessoa Juridica'}">checked</c:if> >Pessoa Juridica
                            </label>
                        </div>
                        <div class="form-group">
                            <label class="control-label" id="dataNascLabel" for="dataNascimento">Data de Nascimento </label>
                            <input class="form-control" value='${doador.dataNascimento}' id="dataNasc" type='date' name='dataNascimento' required>
                        </div>
                        <div class="form-group">
                            <label class="control-label" id="cpfLabel"  for="cpf">CPF: </label>
                            <input class="form-control" value='${doador.cpf}' id="cpf" type='number' name='cpf' >
                        </div>
                        <div class="form-group">
                            <label class="control-label" id="rgLabel" for='rg'>RG:</label>
                            <input class="form-control" value='${doador.rg}' id="rg" type='number' name='rg' placeholder="Opcional" >
                        </div>
                        <div class="form-group">
                            <label class="control-label" id="emailLabel" for='email'>Email: </label>
                            <input class="form-control" value='${doador.email}' id="email" type='email' name='email' placeholder='seunome@site.com' >
                        </div>
                        <div class="form-group">
                            <label class="control-label" id="telefoneLabel" for='telefone'>Telefone: </label>
                            <input class="form-control"  value='${doador.telefone}' id="telefone" type='number' name='telefone' placeholder="Opcional">
                        </div>
                        <div class="form-group">
                            <label class="control-label" id="celularLabel" for='celular'>Celular: </label>
                            <input class="form-control" value='${doador.celular}' id="celular" type='number' name='celular' >
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label" id="cepLabel" for='cep'>CEP: </label>
                            <input class="form-control" value='${doador.cep}' id="cep" type='number' name='cep' >
                        </div>
                        <div class="form-group">
                            <label class="control-label" for='endereco'>Endereço: </label>
                            <input class="form-control" value='${doador.endereco}' type='text' name='endereco' required>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for='numero'>Número: </label>
                            <input class="form-control" value='${doador.numero}' type='number' name='numero' style="width: 4em" required>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for='bairro'>Bairro: </label>
                            <input class="form-control" type='text' value='${doador.bairro}' name='bairro' required>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for='cidade'>Cidade: </label>
                            <input class="form-control" type='text' value='${doador.cidade}' name='cidade' required>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for='estado'>Estado: </label>
                            <input class="form-control" type='text' value='${doador.estado}' name='estado' required>
                        </div>
                        <div class="form-group">
                            
                            <input name='acao' value='<%
                    if(request.getAttribute("doador")==null) 
                        out.print("Incluir");    
                    else
                        out.print("Alterar");  
                %>' hidden>

                <input name='iddoador' value='${doador.idDoador}' hidden>
                            
                            <input class="btn btn-default" type='submit' value='Enviar' name='nEnviarDoador'>
                            <a href='DoadorServlet?acao=Listar'>Ver Todos Doadores</a>
                        </div>
                    </div>
                </form>

            </div>
        </div>
        <%@include file="rodape.jsp" %>
    </body>
    
  
</html>
<%}
else
response.sendRedirect("login.jsp");%> 