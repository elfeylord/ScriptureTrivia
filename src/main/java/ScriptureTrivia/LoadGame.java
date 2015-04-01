/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptureTrivia;

import Database.CurrentGame;
import Database.DatabaseAccess;
import Database.Game;
import Database.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cole
 */
@WebServlet(name = "LoadGame", urlPatterns = {"/LoadGame"})
public class LoadGame extends HttpServlet {

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
        
        String gameId = request.getParameter("gameId");
        //String userId = request.getParameter("facebookId");
        DatabaseAccess myDB = new DatabaseAccess();
        
        User myUser = (User)request.getSession().getAttribute("user");
        
        //System.out.println("before getting the game facebookId is: " + userId);
        System.out.println("before getting the game gameId is: " + gameId);
        System.out.println("before getting the game gameId is: " + gameId);
        System.out.println("before getting the game gameId is: " + gameId);
        System.out.println("before getting the game gameId is: " + gameId);
        System.out.println("before getting the game gameId is: " + gameId);
        System.out.println("before getting the game gameId is: " + gameId);
        System.out.println("before getting the game gameId is: " + gameId);
        System.out.println("before getting the game gameId is: " + gameId);
        System.out.println("before getting the game gameId is: " + gameId);
        System.out.println("before getting the game gameId is: " + gameId);
        
        Game myGame = myDB.getGame(gameId, myUser);
        
        System.out.println("after getting the game");
        
        if (myGame.getFriend().getScore() >= 21)
        {
            myDB.removeGame(myGame.getGameId());
            request.getRequestDispatcher("lose.jsp").forward(request, response);
        }
        else
        {
        
            request.setAttribute("game", myGame);
            request.getRequestDispatcher("Category").forward(request, response);
    
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
