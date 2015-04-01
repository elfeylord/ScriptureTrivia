/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facebook;

import Database.CurrentGame;
import Database.DatabaseAccess;
import Database.Game;
import Database.User;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Friend;
import facebook4j.ResponseList;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "FacebookParser", urlPatterns = {"/FacebookParser"})
public class FacebookParser extends HttpServlet {

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
        //Get the facebook seesion variable
        Facebook facebook = (Facebook)request.getSession().getAttribute("facebook");
        
        String userName = "";
        String userId = "";
       
        
        //get the facebook profile picture
        try {
            URL profilePic = facebook.getPictureURL();
            request.getSession().setAttribute("profilePic", profilePic);
        } 
        catch (FacebookException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {   
            userId = facebook.getId();
            request.setAttribute("userid", userId);
        
        } catch (FacebookException ex) {
            Logger.getLogger(FacebookParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(FacebookParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //get the facebook user name
        try {
            userName = facebook.getName();
            request.setAttribute("username", userName);
        } 
        catch (FacebookException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IllegalStateException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Get facebook friends
        try {
            
            
            ResponseList<Friend> friends = facebook.getFriends();
            List<FacebookFriend> sendList = new ArrayList();
            
            for(Friend friend : friends){
                FacebookFriend tempFriend = new FacebookFriend();
                tempFriend.setId(friend.getId());
                tempFriend.setName(friend.getName());
                sendList.add(tempFriend);                
            }
            request.setAttribute("friends", sendList);
            //response.getWriter().write("name:" + sendList.get(0).getName());
        } 
        catch (FacebookException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        DatabaseAccess myDB = new DatabaseAccess();
        
        User user = new User(userId, userName, 0, true);
        
        myDB.checkUser(user);

        //send the list to the main menu.
        //the ID is hard coded
        List<Game> games = myDB.getGames(user);        
        
        List<Game> yourGames = new ArrayList();
        List<Game> theirGames = new ArrayList();
        
        for (Game game : games)
        {
            if (game.getUser().getIsTurn() == true)
            {
                yourGames.add(game);
            }
            else
            {
                theirGames.add(game);
 
            }
        }
        request.getSession().setAttribute("user", user);
        
        request.setAttribute("yourGames", yourGames);
        request.setAttribute("theirGames", theirGames);
        //Send the friends
        
        request.getRequestDispatcher("mainMenu.jsp").forward(request, response);
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
