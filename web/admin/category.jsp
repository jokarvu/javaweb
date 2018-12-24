<%-- 
    Document   : index
    Created on : Dec 21, 2018, 11:43:02 AM
    Author     : mito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="dao.DAOCategory" %>
<%@ page import="model.Category" %>
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
                <span>Category</span>
                <a href='<%= path + "/admin/category/create.jsp" %>' class="btn btn-success btn-sm float-right">Add New Category</a>
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
                        <% for(Category cat : DAOCategory.getListCategory()) { %>
                        <tr>
                            <th scope="row"><%= cat.getId() %></th>
                            <td><%= cat.getName() %></td>
                            <td><%= cat.getCreated_at() %></td>
                            <td><%= cat.getUpdated_at() %></td>
                            <td>
                                <a href='<%= path + "/category/edit.jsp?id=" + cat.getId() %>' class="btn btn-sm btn-info"><i class="fa fa-edit"></i></a>
                                <a href='<%= path + "/category/delete.jsp?id=" + cat.getId() %>' class="btn btn-sm btn-danger"><i class="fa fa-trash-alt"></i></a>
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