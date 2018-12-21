<%-- 
    Document   : index
    Created on : Dec 21, 2018, 11:43:02 AM
    Author     : mito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.DAOBook" %>
<%@ page import="model.Book" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book</title>
</head>

<body>
    <jsp:include page="./layouts/header.jsp" />
    <div class="col-md-9">
        <div class="card">
            <div class="card-header main-color-bg">
                <span>Book</span>
            </div>
            <div class="card-body">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Author</th>
                            <th scope="col">Category</th>
                            <th scope="col">Created</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Book book : DAOBook.getListBook()) { %>
                        <tr>
                            <th scope="row"><%= book.getId() %></th>
                            <td><%= book.getName() %></td>
                            <td><%= book.getAuthor() %></td>
                            <td><%= book.getCat_id() %></td>
                            <td><%= book.getCreated_at() %></td>
                            <td>Xóa | Sửa</td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </div>
    </div>
    <jsp:include page="./layouts/footer.jsp" />
</body>

</html>