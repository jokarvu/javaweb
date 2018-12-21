<%-- 
    Document   : index
    Created on : Dec 13, 2018, 10:52:46 AM
    Author     : mito
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="dao.DAOBook" %>
<%@ page import="model.Book" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book's Detail</title>
    </head>
    <body>
        <%
            Book book = new Book();
            int id = Integer.parseInt(request.getParameter("bookId"));
            book = DAOBook.findBook(id);
        %>
        <jsp:include page="./layouts/header.jsp"/>
        <!-- Main -->
        <h2 class="text-muted">Thông tin sách</h2>
        <hr>
        <div class="row mb-5">
            <div class="col-md-4 text-center">
                <img src="<%= "/shop/images/book/" + book.getSlug() + ".gif" %>" alt="Card image ca-p" width="250px">
            </div>
            <div class="col-md-8">
                <h4 class="text-primary mb-3">
                    <%= book.getName() %>
                </h4>
                <p class="text-muted">
                    <%= book.getAuthor() %>
                </p>
                <h2>
                    <i class="fa fa-cart-plus" book_id="<%= book.getId() %>" style="cursor: pointer"></i>
                </h2>
                <p class="text-muted">
                    Mô tả:
                </p>
                <p class="text-muted">
                    <%= book.getDes() %>
                </p>
            </div>
        </div>
        <!-- Footer -->
        <jsp:include page="./layouts/footer.jsp"/>
    </body>
</html>
