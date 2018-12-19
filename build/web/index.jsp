<%-- 
    Document   : index
    Created on : Dec 13, 2018, 10:52:46 AM
    Author     : mito
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.DAOBook" %>
<%@ page import="model.Book" %>
<%@ page import="dao.DAOCategory" %>
<%@ page import="model.Category" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demin Shop</title>
        <link rel="stylesheet" href="./css/bootstrap.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/app.css">
    </head>
    <body>
        <jsp:include page="./layouts/header.jsp"/>
        <!-- Main -->
        <!-- Sách mới -->
        <div class="card bg-white mb-3 justify-content-center mb-5">
            <div class="card-header">
                <h4 class="text-success">Sách Mới</h4>
            </div>
            <div class="card-body card-deck" id="new-book">
                <%
                    for(Book b : DAOBook.getBookByCon("ORDER BY created_at DESC LIMIT 4")) { 
                %>
                <div class="card zoom mb-4">
                    <img class="card-img-top" src="<%= "/shop/images/book/" + b.getSlug() + ".gif" %>" alt="Card image cap" width="280px" height="400px">
                    <div class="card-body">
                        <h5 class="card-title"><%= b.getName() %></h5>
                        <p class="card-text text-muted"><%= b.getAuthor() %></p>
                        <p class="card-text"><b><%= b.getPrice() %> đ</b></p>
                        <i class="fa fa-cart-plus" id="<%= b.getId() %>"></i>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
            <button class="btn btn-light load-more" mode="new">See more</button>
        </div>

        <!-- Sách bán chạy -->
        <div class="card bg-white mb-3 mb-5">
            <div class="card-header">
                <h4 class="text-primary">Sách Bán Chạy</h4>
            </div>
            <div class="card-body card-deck">
                <%
                    for(Book b : DAOBook.getBookByCon("ORDER BY total_quantity - left_quantity DESC LIMIT 8")) { 
                %>
                <div class="card zoom mb-4">
                    <img class="card-img-top" src="<%= "/shop/images/book/" + b.getSlug() + ".gif" %>" alt="Card image cap" height="400px">
                    <div class="card-body">
                        <h5 class="card-title"><%= b.getName() %></h5>
                        <p class="card-text text-muted"><%= b.getAuthor() %></p>
                        <p class="card-text"><b><%= b.getPrice() %> đ</b></p>
                        <i class="fa fa-cart-plus" id="<%= b.getId() %>"></i>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
            <button class="btn btn-light load-more" mode="hot">See more</button>
        </div>

        <!-- Sách theo category -->
        <% DAOCategory category = new DAOCategory(); %>
        <% for(Category cat : category.getListCategory()) { %>
        <div class="card bg-white mb-5">
            <div class="card-header">
                <h4 class="text-primary"><%= cat.getName() %></h4>
            </div>
            <div class="card-body card-deck">
                <% for(Book b : DAOBook.getBookByCon("WHERE cat_id = " + cat.getId() + " ORDER BY created_at DESC LIMIT 8")) { %>
                    <div class="card zoom mb-4">
                        <img class="card-img-top" src="<%= "/shop/images/book/" + b.getSlug() + ".gif" %>" alt="Card image cap" height="400px">
                        <div class="card-body">
                            <h5 class="card-title"><%= b.getName() %></h5>
                            <p class="card-text text-muted"><%= b.getAuthor() %></p>
                            <p class="card-text"><b><%= b.getPrice() %> đ</b></p>
                            <i class="fa fa-cart-plus" id="<%= b.getId() %>"></i>
                        </div>
                    </div>
                <% } %>
            </div>
            <button class="btn btn-light load-more" cat_id="<%= cat.getId() %>">See more</button>
        </div>
        <% } %>
        <!-- Footer -->
        <jsp:include page="./layouts/footer.jsp"/>
    </body>
</html>
