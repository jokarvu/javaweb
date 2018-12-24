/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOBook;
import model.Book;

/**
 *
 * @author mito
 */
@WebServlet(name = "bookCreate", urlPatterns = {"/book/create"})
public class create extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet create</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet create at " + request.getContextPath() + "</h1>");
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
        String name = "Phòng Trọ Ba Người";
        try {
            Book book = new Book();
            book.setName(name);
            DAOBook.save(book);
        } catch (SQLException e) {

        }
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
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String des = request.getParameter("des");
        String slug = request.getParameter("slug");
        int cat_id = Integer.parseInt(request.getParameter("cat_id"));
        int total_quantity = Integer.parseInt(request.getParameter("total_quantity"));
        int left_quantity = total_quantity;
        int price = Integer.parseInt(request.getParameter("price"));
        try {
            Book book = new Book();
            book.setName(name);
            book.setAuthor(author);
            book.setDes(des);
            book.setSlug(slug);
            book.setCat_id(cat_id);
            book.setTotal_quantity(total_quantity);
            book.setLeft_quantity(left_quantity);
            book.setPrice(price);
            DAOBook.save(book);
//            response.sendRedirect(request.getContextPath() + "/admin/book.jsp?create=1");
        } catch (SQLException e) {
           response.sendRedirect(request.getContextPath() + "/admin/book/create.jsp?error=1");
            //
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
