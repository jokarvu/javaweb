<%-- 
    Document   : index
    Created on : Dec 21, 2018, 11:43:02 AM
    Author     : mito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="dao.DAOBook" %>
<%@ page import="model.Book" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book</title>
</head>

<body>
    <%@ include file="./layouts/header.jsp" %>
    <div class="col-md-9">
        <div class="card">
            <div class="card-header main-color-bg">
                <span>Book</span>
                <a href='<%= path + "/admin/book/create.jsp" %>' class="btn btn-success btn-sm float-right">Add New Book</a>
            </div>
            <div class="card-body">
                <table class="table table-bordered table-striped" id="book-index">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Author</th>
                            <th scope="col">Category</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Map<String, String> book : DAOBook.getListBook()) { %>
                        <tr>
                            <th scope="row"><%= book.get("id") %></th>
                            <td><%= book.get("name") %></td>
                            <td><%= book.get("author") %></td>
                            <td><%= book.get("cat_name") %></td>
                            <td>
                                <a href='<%= path + "/book/edit.jsp?id=" + book.get("id") %>' class="btn btn-sm btn-info"><i class="fa fa-edit"></i></a>
                                <a href='<%= path + "/book/delete.jsp?id=" + book.get("id") %>' class="btn btn-sm btn-danger"><i class="fa fa-trash-alt"></i></a>
                            </td>
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