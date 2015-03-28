/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facebook;

import Database.CurrentGame;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cordondavies
 */
@WebServlet(name = "Share", urlPatterns = {"/Share"})
public class Share extends HttpServlet {

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
        
        Facebook facebook = (Facebook)request.getSession().getAttribute("facebook");
        CurrentGame myGame = (CurrentGame)request.getSession().getAttribute("game");
        try {
         
            facebook.postLink(new URL("http://scripturetricia-scripturetrivia.rhcloud.com"),
                    "I just smashed " + myGame.getFriendName() + " on Scripture Trivia! You should play too!!");
            //facebook.postLink(new URL("http://scripturetricia-scripturetrivia.rhcloud.com"),
            //        "(test)I just smashed " + "@[" + friendId + ":1:" + friendName + "]" + " on Scripture Trivia! You should play too!!");
           
        } catch (FacebookException ex) {
            Logger.getLogger(Share.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("FacebookParser");
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
