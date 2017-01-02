/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidade.Produto;
import entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.ProdutoDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author Thayse
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "listarUsuario.jsp";
        List<Usuario> lista = new ArrayList<>();
        String mensagem = " ";
        boolean valido = true;
        
        Usuario usuario = new Usuario();
        
        UsuarioDAO dao = new UsuarioDAO();

        try {
            if(!acao.equalsIgnoreCase("Listar") && request.getParameter("usuario")!=null) {
                usuario.setUsername(request.getParameter("username"));
                usuario.setSenha(request.getParameter("senha"));
               
            }
            if (acao.equalsIgnoreCase("Incluir")) {
                usuario.setUsername(request.getParameter("username"));
                usuario.setSenha(request.getParameter("senha"));

                mensagem = dao.inserir(usuario);
                if(mensagem.equals("")){
                    request.setAttribute("mensagem", "O usuário foi cadastrado com sucesso!");
                }
                else{
                    valido = false;
                    request.setAttribute("mensagem", mensagem);
                    destino = "UsuarioServlet?acao=Cadastro";
                }
            }
            else if (acao.equalsIgnoreCase("Alterar")) {
                usuario.setUsername(request.getParameter("username"));
                usuario.setSenha(request.getParameter("senha"));
                usuario.setIdusuario(Integer.parseInt(request.getParameter("idusuario")));
           
                dao.alterar(usuario);
            } 
            else if (acao.equalsIgnoreCase("Excluir")) {
                usuario.setIdusuario(Integer.parseInt(request.getParameter("idusuario")));
                dao.excluir(usuario);
                request.setAttribute("mensagem", "O usuário foi excluido com sucesso!!");  
            } 
            else if (acao.equalsIgnoreCase("Consultar")) {
                usuario.setIdusuario(Integer.parseInt(request.getParameter("idusuario")));
                usuario = dao.consultar(usuario);
                request.setAttribute("usuario", usuario);
                request.setAttribute("mensagem", "Altere o usuário selecionado!");
                destino = "cadastroUsuario.jsp";
            } 
        }
        catch (Exception e) {
            request.setAttribute("mensagem", "Erro: " + e.getMessage());

        }
        
        if(valido){
            lista = dao.listar();
            request.setAttribute("listaUsuario", lista);
        }
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    
}
