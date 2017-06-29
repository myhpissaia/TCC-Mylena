package Model;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */

@WebFilter(urlPatterns={"/home.jsp", "/lista-ongs.jsp", "/doacao.jsp", "/perfil.jsp"})
public class Filtro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpSession session = ((HttpServletRequest)request).getSession();
        
        if(session.getAttribute("usuario") == null) {
            
            chain.doFilter(request, response);
            
            RequestDispatcher rd = ((HttpServletRequest)request).getRequestDispatcher("index.html");
            rd.forward(((HttpServletRequest)request), response);
            
        } else {
            
            chain.doFilter(request, response);
            
        }
        
    }

    @Override
    public void destroy() {}
    
}
