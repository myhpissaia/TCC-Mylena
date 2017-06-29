package Servlet;

import DAO.DoaDAO;
import Model.Doacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class ServletDoacao extends HttpServlet {

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

        String nome = (String) request.getParameter("nome");
        String email = (String) request.getParameter("email");
        String ong = (String) request.getParameter("ong");
        
        String alimento = request.getParameter("alimento");
        String roupa = request.getParameter("roupa");
        String brinquedo = request.getParameter("brinquedo");
        String higiene = request.getParameter("higiene");
        
        try {

            Doacao doa = new Doacao();

            doa.setNome_ong(ong);
            doa.setNome(nome);
            doa.setEmail(email);
            
            doa.setNecAlimento(transformaBoolean(alimento));
            doa.setNecRoupa(transformaBoolean(roupa));
            doa.setNecBrinquedo(transformaBoolean(brinquedo));
            doa.setNecHigiene(transformaBoolean(higiene));
            
            DoaDAO dao = new DoaDAO();
            try {
                dao.insereDoacao(doa);
            } catch (Exception ex) {
                System.out.println("Erro11: " + ex);
            }

            request.setAttribute("mensagem", "Doação realiza com sucesso!");
            request.setAttribute("css_class", "sucesso");

            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);

        } catch (Exception ex) {
            System.out.println("Erro:" + ex);
        }

    }
    
    private boolean transformaBoolean(String tipo) {
        if (tipo == null) {
            return false;
        } else {
            return true;
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
