/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facebook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

/**
 *
 * @author Cole
 */
@WebServlet(name = "FacebookAPI", urlPatterns = {"/FacebookAPI"})
public class FacebookAPI extends HttpServlet {

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
        String accessToken = "CAACEdEose0cBADyZB9d401GYLDQjgXxYZAgRhK4gH0L9JLAGZAEmyMnnOjZB8puajBsXJiLrLiBx5FqwtNCoWjZAsFq97eX3ZCgYdo3MUc9YaZAxR9F4FdeNUFZBD2UW1tIpxhM4NtP5jdDvPf62yRQYeo0xrHAqiJUhc3rYvuUfvl9lUoUrCwWXA3PoGgbFevLuilHXcr61ZAYd8ydKvpI3oUWJWzwUcdZAsZD";
       Facebook facebook = new FacebookTemplate(accessToken, "Scripture Trivia");
       List<FacebookProfile> facebookProfiles = facebook.friendOperations().getFriendProfiles();
       
       List<String> friendsNames = new ArrayList();
       for (int i = 0; i < facebookProfiles.size(); i++){
           friendsNames.add(facebookProfiles.get(i).getFirstName());
       
       }
       
       request.setAttribute("profiles", friendsNames);
       request.getRequestDispatcher("Test2.jsp").forward(request, response);
               
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
