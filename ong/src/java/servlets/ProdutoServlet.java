/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modeloDAO.ProdutoDAO;
import entidade.Produto;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author 0573159
 */
@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "listarProduto.jsp";
        List<Produto> lista = new ArrayList<>();
        String mensagem = " ";
        
        Produto produto = new Produto();
        ProdutoDAO dao = new ProdutoDAO();

        try {
            if(!acao.equalsIgnoreCase("Listar") && request.getParameter("produto")!=null) {
                produto.setNome(request.getParameter("produto"));
                produto.setTipo(request.getParameter("tipo"));
                produto.setPeso(Float.parseFloat(request.getParameter("peso")));    
            }
            if (acao.equalsIgnoreCase("Incluir")) {
                

                dao.inserir(produto);
                request.setAttribute("mensagem", "O produto foi cadastrado com sucesso!");
            
            } else if (acao.equalsIgnoreCase("Alterar")) {
                produto.setId_produto(Integer.parseInt(request.getParameter("id_produto")));
                System.out.println(produto.getId_produto());
                dao.alterar(produto);
                
                
            } else if (acao.equalsIgnoreCase("Excluir")) {
                produto.setId_produto(Integer.parseInt(request.getParameter("id_produto")));
                dao.excluir(produto);
                request.setAttribute("mensagem", "O produto foi excluido com sucesso!!");  
            } else if (acao.equalsIgnoreCase("Consultar")) {
                produto.setId_produto(Integer.parseInt(request.getParameter("id_produto")));
                produto = dao.consultar(produto);
                request.setAttribute("produto", produto);
                request.setAttribute("mensagem", "Altere o produto selecionado!");
                destino = "cadastroProduto.jsp";
            }
            
            
            
            
            
        } catch (Exception e) {
            request.setAttribute("mensagem", "Erro: " + e.getMessage());

        }
        
        lista = dao.listar();
        request.setAttribute("listaProduto", lista);
        //request.setAttribute("mensagem", mensagem);

        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);


    }
}
