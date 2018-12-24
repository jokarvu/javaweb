<%-- 
    Document   : index
    Created on : Dec 21, 2018, 11:43:02 AM
    Author     : mito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="dao.DAOUser" %>
<%@ page import="model.User" %>
<%@ page import="dao.DAOInvoice" %>
<%@ page import="model.Invoice" %>
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
                <span>Invoice</span>
                <a href='<%= path + "/admin/invoice/create.jsp" %>' class="btn btn-success btn-sm float-right">Add New Invoice</a>
            </div>
            <div class="card-body">
                <table class="table table-bordered table-striped" id="book-index">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Username</th>
                            <th scope="col">Total</th>
                            <th scope="col">Shipping</th>
                            <th scope="col">Created</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Invoice invoice : DAOInvoice.getListInvoice()) { %>
                        <tr>
                            <th scope="row"><%= invoice.getId() %></th>
                            <td><%= DAOUser.find(invoice.getUser_id()).getUsername() %></td>
                            <td><%= invoice.getTotal() %></td>
                            <td><%= invoice.getShip_tax() %></td>
                            <td><%= invoice.getCreated_at() %></td>
                            <td>
                                <a href='<%= path + "/invoice/edit.jsp?id=" + invoice.getId() %>' class="btn btn-sm btn-info"><i class="fa fa-edit"></i></a>
                                <a href='<%= path + "/invoice/delete.jsp?id=" + invoice.getId() %>' class="btn btn-sm btn-danger"><i class="fa fa-trash-alt"></i></a>
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