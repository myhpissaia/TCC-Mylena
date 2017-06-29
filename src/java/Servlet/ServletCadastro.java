package Servlet;

import DAO.UsuarioDAO;
import Model.Criptografia;
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

        String pagina = "login.jsp";

        String cssEmail = "erro";
        String cssSenha = "erro";

        try {
            if (senha.equals(confirmarSenha)) {
                senha = Criptografia.criptografar(senha);
                confirmarSenha = Criptografia.criptografar(confirmarSenha);

                if (email.contains("@")) {

                    UsuarioDAO dao1 = new UsuarioDAO();

                    if (dao1.getUsuario().size() > 0) {

                        for (Usuario usuario1 : dao1.getUsuario()) {

                            if (!usuario1.getEmail().equals(email)) {

                                Usuario usuario = new Usuario();
                                usuario.setNome(nome);
                                usuario.setSobrenome(sobrenome);
                                usuario.setEmail(email);
                                usuario.setLogin(login);
                                usuario.setSenha(senha);
                                usuario.setConsenha(confirmarSenha);

                                UsuarioDAO dao = new UsuarioDAO();
                                try {
                                    dao.insereUsuario(usuario);
                                } catch (Exception ex) {
                                    System.out.println("Erro:" + ex);
                                }

                                cssEmail = "";
                                cssSenha = "";

                                pagina = "login.jsp";

                                break;
                            }

                        }

                    } else {

                        Usuario usuario = new Usuario();
                        usuario.setNome(nome);
                        usuario.setSobrenome(sobrenome);
                        usuario.setEmail(email);
                        usuario.setLogin(login);
                        usuario.setSenha(senha);
                        usuario.setConsenha(confirmarSenha);

                        UsuarioDAO dao = new UsuarioDAO();
                        try {
                            dao.insereUsuario(usuario);
                        } catch (Exception ex) {
                            System.out.println("Erro:" + ex);
                        }

                        cssEmail = "";
                        cssSenha = "";

                        pagina = "login.jsp";

                    }

                } else {

                    cssEmail = "erro";
                    cssSenha = "";

                    pagina = "cadastro.jsp";

                }

            } else {

                cssEmail = "";
                cssSenha = "erro";

                pagina = "cadastro.jsp";

            }
        } catch (Exception ex) {
            System.out.println("Erro:" + ex);
        }

        request.setAttribute("css-email", cssEmail);
        request.setAttribute("css-senha", cssSenha);

        RequestDispatcher rd = request.getRequestDispatcher(pagina);
        rd.forward(request, response);

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
