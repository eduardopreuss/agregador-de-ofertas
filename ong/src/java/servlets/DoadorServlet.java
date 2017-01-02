/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidade.Doador;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.DoadorDAO;

/**
 *
 * @author 0584150
 */
@WebServlet("/DoadorServlet")
public class DoadorServlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String acao = request.getParameter("acao");
       String destino = "listarDoador.jsp";
        List<Doador> lista = new ArrayList<>();
        String mensagem = " ";
 
                Doador doador = new Doador();
                
                DoadorDAO dao = new DoadorDAO();
                
               
		
                
            try {
            if(!acao.equalsIgnoreCase("Listar") && request.getParameter("nome")!=null) {
                
                    doador.setNome(request.getParameter("nome"));
                    doador.setSexo(request.getParameter("sexo"));
                    doador.setStatus(request.getParameter("status"));
                    doador.setTipo(request.getParameter("tipo"));
                    doador.setCpf(request.getParameter("cpf"));
                    doador.setRg(request.getParameter("rg"));
                    doador.setEmail(request.getParameter("email"));
                    doador.setTelefone(request.getParameter("telefone"));
                    doador.setCelular(request.getParameter("celular"));
                    doador.setCep(request.getParameter("cep"));
                    doador.setEndereco(request.getParameter("endereco"));
                    doador.setNumero(request.getParameter("numero"));
                    doador.setBairro(request.getParameter("bairro"));
                    doador.setCidade(request.getParameter("cidade"));
                    doador.setEstado(request.getParameter("estado"));
                    doador.setDataNascimento(java.sql.Date.valueOf(request.getParameter("dataNascimento")));
                    
                    
            }
                
            if (acao.equalsIgnoreCase("Incluir")) {
                

               dao.inserir(doador);
               
                request.setAttribute("mensagem", "O doador foi cadastrado com sucesso!");
            
            } else if (acao.equalsIgnoreCase("Alterar")) {
                
                doador.setIdDoador(Integer.parseInt(request.getParameter("iddoador")));
                
                dao.alterar(doador);
                
                
                
            } else if (acao.equalsIgnoreCase("Excluir")) {
                doador.setIdDoador(Integer.parseInt(request.getParameter("iddoador")));
                dao.excluir(doador);
                request.setAttribute("mensagem", "O doador foi excluido com sucesso!!");  
            } else if (acao.equalsIgnoreCase("Consultar")) {
                doador.setIdDoador(Integer.parseInt(request.getParameter("iddoador")));
                doador = dao.consultar(doador);
                
                request.setAttribute("doador", doador);
                request.setAttribute("mensagem", "Altere o doador selecionado!");
                
                destino = "cadastroDoador.jsp";
            }
            
            
            
            
            
        } catch (Exception e) {
            request.setAttribute("mensagem", "Erro: " + e.getMessage());

        }
        
        lista = dao.listar();
        request.setAttribute("listaDoador", lista);
        //request.setAttribute("mensagem", mensagem);

        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);


    }
}
