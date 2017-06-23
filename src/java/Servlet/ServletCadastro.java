package Servlet;

import Model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author  <Leticia e Mylena>
 */
public class ServletCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String confirmarSenha = request.getParameter("consenha");

        try {
            if (senha.equals(confirmarSenha)) {

                Usuario usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setSobrenome(sobrenome);
                usuario.setEmail(email);
                usuario.setLogin(login);
                usuario.setSenha(senha);
                usuario.setConsenha(confirmarSenha);

                /*PessoaDAO dao = new PessoaDAO();
                try {
                    dao.insereUsuario(user);
                } catch (Exception ex) {
                    System.out.println("Erro:" + ex);
                }*/

                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);

            } else {

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
