/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author mito
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DAOUser user = new DAOUser();
        ArrayList<User> result = new ArrayList<>();
        try {
            result = user.getUserByCon("WHERE username='" + username + "' AND password='" + password + "'");
            if (!result.isEmpty()) {
                response.getWriter().println("ok");
                response.getWriter().println(result.size());
            } else {
                response.getWriter().println("failed");
                response.getWriter().println(result.size());
            }
        } catch (SQLException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
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
        HttpSession session = request.getSession();
        // Check login
        if (session.getAttribute("username") != null) {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DAOUser users = new DAOUser();
        ArrayList<User> result = new ArrayList<>();
        try {
            result = users.getUserByCon("WHERE username='" + username + "' AND password='" + password + "'");
            if (!result.isEmpty()) {
                User user = result.get(0);
                session.setAttribute("username", user.getUsername());
                session.setAttribute("role", user.getRole());
                // response.getWriter().println(session.getAttribute("username"));
                // response.getWriter().println(session.getAttribute("role"));
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            } else {
                response.sendRedirect(request.getContextPath()+"/login.jsp?error=1");
            }
        } catch (SQLException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        }
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
