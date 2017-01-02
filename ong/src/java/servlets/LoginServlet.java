/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


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
import javax.servlet.http.HttpSession;

import modeloDAO.UsuarioDAO;

/**
 *
 * @author Thayse
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Usuario user = new Usuario();
            user.setUsername(request.getParameter("nLogin"));
            user.setSenha(request.getParameter("nSenha"));
            user = UsuarioDAO.login(user);
            String mensagem = " ";
            if (user.isValid()) {

                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("index.jsp");
                request.setAttribute("mensagem", "Username ou senha inválidos");
            }
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}
