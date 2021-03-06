/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScriptureTrivia;

import Database.DatabaseAccess;
import Database.TriviaQuestion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
@WebServlet(name = "GameStart", urlPatterns = {"/GameStart"})
public class GameStart extends HttpServlet {

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
        System.out.println("testing GameStart");
        
        String category = request.getParameter("category");
        
        //create a database access object
        DatabaseAccess database = new DatabaseAccess();
        //get a question from the database
        /************************************ CHANGE!!!!!! *********************************/
        /**********************************************************************************/
        /**********************************************************************************/
        //TriviaQuestion questionObj = (TriviaQuestion)database.getQuestion(category);
        TriviaQuestion questionObj = (TriviaQuestion)database.getQuestion("New Testament");
               
        //send the question the the JSP
        List<String> answerString = questionObj.getAnswerList();
        String question = questionObj.getQuestion();
        String answer = questionObj.getCorrectA();
        
        
        request.setAttribute("category", category);
        Collections.shuffle(answerString);
        request.setAttribute("answerList", answerString);
        request.setAttribute("answer", (answerString.indexOf(answer)+3)*5);
        request.setAttribute("question", question);
        
        request.getRequestDispatcher("Game.jsp").forward(request, response);
        
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
