<%-- 
    Document   : menu
    Created on : 04/10/2016, 10:47:46
    Author     : 0573159
--%>
<%@page import="entidade.Usuario"%>
<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="js/script.js" type="text/javascript"></script>

<div id="header">
    <div class="col-md-5">
        <a href="index.jsp"> <img id="logo" src="imagens/logo.png" alt="Logo"/> </a>
    </div>
    <div style="margin-top: 2%" id="acessibilidade" class="navbar">
        <ul class="nav navbar-nav pull-right">

            <li><a href="javascript:aumentar();" class="font-button">A+</a> </li>
            <li><a href="javascript:diminuir();" class="font-button">A-</a> </li>
            <li><a href="javascript:normal();" class="font-button">A</a> </li>
            <li><a id="contraste" href="javascript:mudarPreto();" class="font-button">Contraste</a>  </li>

        </ul>
        
    </div>
    
        <ul style="padding-top: 1%" class="nav navbar-nav pull-right">
            <li><% Usuario currentUser = (Usuario)(session.getAttribute("currentSessionUser"));%> Olá <%= currentUser.getUsername() %></li>
            <li> <a style="padding-top: 0; padding-bottom: 0" href="LogoutServlet">Logout</a> </li>
        </ul>
    
    <div>
    
         
            
    </div>
</div>

<div id="lateral" class="col-md-3">
    <div class="menu">

        <ul class="nav">

            <li><a href="#" id="btn-1" data-toggle="collapse" data-target="#submenu1" aria-expanded="false">Estoque</a>
                <ul class="nav collapse" id="submenu1" role="menu" aria-labelledby="btn-1">
                    <li><a href="cadastroProduto.jsp">Cadastrar Produto</a></li>
                    <li><a href="ProdutoServlet?acao=Listar">Listar Produto</a></li>
                    <li><a href="DoacaoServlet?acao=Cadastro">Cadastrar Doação</a></li>
                    <li><a href="DoacaoServlet?acao=Listar">Listar Doações</a></li>

                </ul>
            </li>
            <li><a href="#" id="btn-2" data-toggle="collapse" data-target="#submenu2" aria-expanded="false">Doadores</a>
                <ul class="nav collapse" id="submenu2" role="menu" aria-labelledby="btn-1">
                    <li><a href="cadastroDoador.jsp">Cadastrar Doadores</a></li>
                    <li><a href="DoadorServlet?acao=Listar">Listar Doadores</a></li>
                </ul>
            </li>
            <li><a href="RelatorioServlet?acao=Index">Relatórios</a></li>
            <li class="divider"></li>
            <li><a href="#" id="btn-2" data-toggle="collapse" data-target="#submenu3" aria-expanded="false">Conta</a>
                <ul class="nav collapse" id="submenu3" role="menu" aria-labelledby="btn-1">
                    <li><a href="cadastroUsuario.jsp">Cadastrar Conta de Usuário</a></li>
                    <li><a href="UsuarioServlet?acao=Listar">Listar Usuários</a></li>
                </ul>
            </li>

        </ul>

    </div>
</div>


