<%-- 
    Document   : header
    Created on : Dec 16, 2018, 2:04:01 PM
    Author     : mito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.DAODashboard" %>
<%@ page import="dao.DAOCategory" %>
<%@ page import="model.Category" %>
<% String path = request.getContextPath(); %>
<%
    if(session.getAttribute("username") != null && session.getAttribute("role").equals(1)) {
        //
    } else {
        response.sendRedirect(request.getContextPath());
    }

%>
<!DOCTYPE html>
<link rel="stylesheet" href="<%= path %>/css/bootstrap.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
    crossorigin="anonymous">
<!-- <link rel="stylesheet" href="/shop/css/datatables.css"> -->
<link rel="stylesheet" href="<%= path %>/css/datatables-custom.css">
<link rel="stylesheet" href="<%= path %>/css/app.css">
<link rel="stylesheet" href="<%= path %>/css/toastr.min.css">
<nav class="navbar navbar-expand-sm main-color-bg navbar-dark">
    <a class="navbar-brand" href="#">Logo</a>
</nav>
<section class="mt-3">
    <div class="container-fluid">
        <ol class="breadcrumb" id="breadcrumb">
            <li class="breadcrumb-item active">Dashboard</li>
        </ol>
    </div>
</section>
<div class="container-fluid">
    <div class="row mt-4">
        <div class="col-md-3">
            <div class="list-group">
                <a href="<%= path %>/admin" class="list-group-item list-group-item-action active main-color-bg">
                    <i class="fa fa-cog icon-sidebar"></i>Dashboard
                </a>
                <a href="<%= path %>/admin/user.jsp" class="list-group-item list-group-item-action">
                    <i class="fa fa-user icon-sidebar"></i>
                    User 
                    <span class="badge badge-danger float-right">
                        <% out.print(DAODashboard.counter().get("user_count")); %>
                    </span>
                </a>
                <a href="<%= path %>/admin/book.jsp" class="list-group-item list-group-item-action">
                    <i class="fa fa-book icon-sidebar"></i>
                    Book 
                    <span class="badge badge-danger float-right">
                        <% out.print(DAODashboard.counter().get("book_count")); %>
                    </span>
                </a>
                <a href="<%= path %>/admin/category.jsp" class="list-group-item list-group-item-action">
                    <i class="fa fa-align-justify icon-sidebar"></i>
                    Category <span class="badge badge-danger float-right">
                        <% out.print(DAODashboard.counter().get("category_count")); %>
                    </span>
                </a>
                <a href="<%= path %>/admin/invoice.jsp" class="list-group-item list-group-item-action">
                    <i class="fa fa-receipt icon-sidebar"></i>
                    Invoice <span class="badge badge-danger float-right">
                        <% out.print(DAODashboard.counter().get("invoice_count")); %>
                    </span>
                </a>
            </div>
        </div>