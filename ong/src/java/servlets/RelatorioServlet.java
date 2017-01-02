/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;
import entidade.Doacao;
import entidade.Doador;
import javax.servlet.RequestDispatcher;
import modeloDAO.DoadorDAO;
import modeloDAO.RelatorioDAO;

/**
 *
 * @author 0573159
 */
@WebServlet("/RelatorioServlet")
public class RelatorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "relatorios.jsp";
        List<Doacao> lista = new ArrayList<>();
        List<Doador> listaD = new ArrayList<>();
        DoadorDAO daoDoador = new DoadorDAO();
        RelatorioDAO daoRelatorio = new RelatorioDAO();
        int periodo;
        int idDoador;
        try {
            try{
                periodo = Integer.parseInt(request.getParameter("periodo"));
            }
            catch(Exception e){
                periodo = 30;
            }
            if(acao.equalsIgnoreCase("RelatorioDoacoesDoDoador")){
                listaD = daoDoador.listar();
                request.setAttribute("listaDoador", listaD);
                destino = "relatorioDoacoesDoDoadorNoPeriodo.jsp";
            }
            else if(acao.equalsIgnoreCase("MaioresDoadores")){
                lista = daoRelatorio.maioresDoadores(periodo);
                request.setAttribute("listaDoacao", lista);
                destino = "relatorioMaioresDoadores.jsp";
            }
            else if(acao.equalsIgnoreCase("DoadoresSemDoacoes")){
                lista = daoRelatorio.doadoresSemDoacoes(periodo);
                request.setAttribute("listaDoacao", lista);
                destino = "relatorioDoadoresSemDoacoesNoPeriodo.jsp";
            }
            else if(acao.equalsIgnoreCase("TotalDeCadaProduto")){
                lista = daoRelatorio.quantidadeDeCadaProduto(periodo);
                request.setAttribute("listaDoacao", lista);
                destino = "relatorioTotalDeCadaProduto.jsp";
            }
            else if(acao.equalsIgnoreCase("TodasAsDoacoes")){
                lista = daoRelatorio.listarTodasDoacoes(periodo);
                request.setAttribute("listaDoacao", lista);
                destino = "relatorioTodasAsDoacoes.jsp";
            }
            else if(acao.equalsIgnoreCase("DoacoesDoDoadorNoPeriodo")){
                try{
                    idDoador = Integer.parseInt(request.getParameter("doador"));
                }
                catch(Exception e){
                    idDoador = 1;
                }
                listaD = daoDoador.listar();
                request.setAttribute("listaDoador", listaD);
                lista = daoRelatorio.doacoesDoDoadorNoPeriodo(idDoador, periodo);
                request.setAttribute("listaDoacao", lista);
                destino = "relatorioDoacoesDoDoadorNoPeriodo.jsp";
            }
        } 
        catch (Exception e) {
            request.setAttribute("mensagem", "Erro: " + e.getMessage());
        }
        if(!acao.equalsIgnoreCase("RelatorioDoacoesDoDoador")){
            if(lista.isEmpty()){
                request.setAttribute("mensagemResultado", "Não foram encontrados resultados!");
            }
            else if(lista.size() == 1){
                request.setAttribute("mensagemResultado", "Foi encontrado 1 resultado!");
            }
            else{
                request.setAttribute("mensagemResultado", "Foram encontrados " + lista.size() + " resultados!");
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
}