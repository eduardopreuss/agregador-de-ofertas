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

import modeloDAO.DoacaoDAO;
import entidade.Doacao;
import entidade.Doador;
import entidade.Produto;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author 0573159
 */
@WebServlet("/DoacaoServlet")
public class DoacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "listarDoacao.jsp";
        List<Doacao> lista = new ArrayList<>();
        String mensagem = " ";
        boolean valido = true;
        List<Doador> listaD = new ArrayList<>();
        List<Produto> listaP = new ArrayList<>();
        Doacao doacao = new Doacao();
        DoacaoDAO dao = new DoacaoDAO();

        try {
            if(acao.equalsIgnoreCase("Cadastro")) {
                listaD = dao.listarDoador();
                request.setAttribute("listaDoador", listaD);
                listaP = dao.listarProduto();
                request.setAttribute("listaProduto", listaP);
                request.setAttribute("acao", "Inserir");
                destino = "cadastroDoacao.jsp";
                
            }
            
            if(!acao.equalsIgnoreCase("Listar") && request.getParameter("doacao")!=null) {
                
                doacao.setDoador(Integer.parseInt(request.getParameter("doador")));
                doacao.setProduto(Integer.parseInt(request.getParameter("produto")));
                doacao.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                doacao.setDataVal(java.sql.Date.valueOf(request.getParameter("dataVal")));
                doacao.setDataDoacao(java.sql.Date.valueOf(request.getParameter("dataDoacao")));
            }
            if (acao.equalsIgnoreCase("Incluir")) {
                
                doacao.setDoador(Integer.parseInt(request.getParameter("doador")));
                doacao.setProduto(Integer.parseInt(request.getParameter("produto")));
                doacao.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                doacao.setDataVal(java.sql.Date.valueOf(request.getParameter("dataVal")));
                doacao.setDataDoacao(java.sql.Date.valueOf(request.getParameter("dataDoacao")));
                
                mensagem = dao.inserir(doacao);
                if(mensagem.equals("")){
                     request.setAttribute("mensagem", "A doacao foi cadastrada com sucesso!");
                }
                else{
                    valido = false;
                    request.setAttribute("mensagem", mensagem);
                    destino = "DoacaoServlet?acao=Cadastro";
                }
            
            } 
            else if (acao.equalsIgnoreCase("Alterar")) {
                doacao.setId_doacao(Integer.parseInt(request.getParameter("id_doacao")));
                doacao.setDoador(Integer.parseInt(request.getParameter("doador")));
                doacao.setProduto(Integer.parseInt(request.getParameter("produto")));
                doacao.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                doacao.setDataVal(java.sql.Date.valueOf(request.getParameter("dataVal")));
                doacao.setDataDoacao(java.sql.Date.valueOf(request.getParameter("dataDoacao")));
                System.out.println(doacao.getId_doacao());
                dao.alterar(doacao);
            } 
            else if (acao.equalsIgnoreCase("Excluir")) {
                doacao.setId_doacao(Integer.parseInt(request.getParameter("id_doacao")));
                dao.excluir(doacao);
                request.setAttribute("mensagem", "A doação foi excluída com sucesso!!");  
            } 
            else if (acao.equalsIgnoreCase("Consultar")) {
                doacao.setId_doacao(Integer.parseInt(request.getParameter("id_doacao")));
                doacao = dao.consultar(doacao);
                request.setAttribute("doacao", doacao);
                request.setAttribute("acao", "Consultar");
                request.setAttribute("mensagem", "Altere a doação selecionada!");
                destino = "DoacaoServlet?acao=Cadastro";
            }  
        } 
        catch (Exception e) {
            request.setAttribute("mensagem", "Erro: " + e.getMessage());
        }
        if(valido){
            lista = dao.listar();
            request.setAttribute("listaDoacao", lista);
        }
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
}
