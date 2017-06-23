/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.PessoaDAO;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author  <Leticia e Mylena>
 */
public class Servlet_Cadastro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            System.out.println("aqui");
            String nome = (String) request.getParameter("nome");
            String sobrenome = (String) request.getParameter("sobrenome");
            String email = (String) request.getParameter("email");
            String login = (String) request.getParameter("login");
            String senha = (String) request.getParameter("senha");
            String consenha = (String) request.getParameter("consenha");

            if (senha.equals(consenha)) {

                Usuario user = new Usuario();

                user.setNome(nome);
                user.setSobrenome(sobrenome);
                user.setEmail(email);
                user.setLogin(login);
                user.setSenha(senha);
                user.setConsenha(consenha);

                PessoaDAO dao = new PessoaDAO();
                try {
                    dao.insereUsuario(user);
                } catch (Exception ex) {
                    System.out.println("Erro:" + ex);
                }
                
                request.setAttribute("mensagem", "Usuário cadastrado com sucesso!");
                request.setAttribute("css_class", "sucesso");

                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);

            } else {

                request.setAttribute("mensagem", "Erro ao cadastrar usuário!");
                request.setAttribute("css_class", "erro");

                RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
                rd.forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("Erro:" + ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
