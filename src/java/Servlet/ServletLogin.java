package Servlet;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        /*UsuarioDAO cad = new UsuarioDAO();
        ObservableList<Usuario> user = (ObservableList<Usuario>) cad.getUsuario();*/

        /*for (Usuario pes : user) {

            if ((login.equals(pes.getLogin())) && senha.equals(pes.getSenha())) {

                login_user = pes.getLogin();
                
        */
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);

        /*        break;
            }
        }*/

        //RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        //rd.forward(request, response);

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
