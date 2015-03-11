/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facebook;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cordondavies
 */
@WebServlet(urlPatterns = {"/TestFacebookConnection"})
public class TestFacebookConnection extends HttpServlet {

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
        String secret = "641ad98fc2cd744beed7d518e0d4d76a";
        String appId = "446783372140064";
        String accessToken = "CAAGWWNwwHiABAJVZC8ZCn8J1ysXSkKfZAOwGhCjSnwIZC9TqRNDLZAZCR9AzCUqIMvIQKJZBcGZAOZAhqttkc02AA97IvPjmZBGLZCAn0ShN02XB4vCICQioN6Tu6pfqHNDTmWpZBzFB3cvD6omd5BL6wRLHvBhNj2hyGFMObfEjo76ni5ieQUtAVkBtfE0nRD03E8RwRmKM78q0WUpqCtFyqTNo";
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, secret);
        User user = facebookClient.fetchObject("me", User.class);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloWorld</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloWorld at " + request.getContextPath() + "</h1>");
            out.println("User name: " + user.getName());
            out.println("</body>");
            out.println("</html>");
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
