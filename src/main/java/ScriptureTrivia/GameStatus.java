/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptureTrivia;

import Database.CurrentGame;
import Database.DatabaseAccess;
import Database.Game;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cole
 */
@WebServlet(name = "GameStatus", urlPatterns = {"/GameStatus"})
public class GameStatus extends HttpServlet {

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
        String correct = request.getParameter("correct");
        
        DatabaseAccess myDB = new DatabaseAccess();               
        Game game = (Game)request.getSession().getAttribute("game");
        if ("true".equals(correct)){ 
            game.getUser().setScore(game.getUser().getScore() + 1);
            game.setGameId(1);
            if (game.getUser().getScore() >= 21)
            {
                game.getUser().setIsTurn(false);
                game.getFriend().setIsTurn(true);
                
                myDB.saveGame(game);
                
                response.sendRedirect("win.jsp");
                
            }
            else
            {
                myDB.saveGame(game);
                request.setAttribute("game", game);
                request.getRequestDispatcher("Category").forward(request, response);
            }
        }
        else
        {
            game.getUser().setIsTurn(false);
            game.getFriend().setIsTurn(true);
            myDB.saveGame(game);
            
            response.sendRedirect("FacebookParser");
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
