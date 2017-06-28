package Servlet;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author  <Leticia e Mylena>
 */
public class ServletLogin extends HttpServlet {

    public static String login_user;

    public static ObservableList<Usuario> cadastro = FXCollections.observableArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        UsuarioDAO cad = new UsuarioDAO();
        List<Usuario> user = cad.getUsuario();

        String pagina = "login.jsp";
        
        String cssLogin = "erro";
        String cssSenha = "erro";
        
        for (Usuario usuario : user) {

            if ((login.equals(usuario.getLogin())) && senha.equals(usuario.getSenha())) {

                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                
                cssLogin = "";
                cssSenha = "";
                
                pagina = "home.jsp";

                break;
                
            } else if (login.equals(usuario.getLogin())) {

                cssLogin = "";
                cssSenha = "erro";
                
                pagina = "login.jsp";

                break;
                
            } else if (senha.equals(usuario.getSenha())) {

                cssLogin = "erro";
                cssSenha = "";
                
                pagina = "login.jsp";

                break;
                
            }
        }

        request.setAttribute("css-login", cssLogin);
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
