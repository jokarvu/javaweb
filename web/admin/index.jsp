<%-- 
    Document   : index
    Created on : Dec 21, 2018, 11:43:02 AM
    Author     : mito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.DAODashboard" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Dashboard</title>
</head>

<body>
        <%@ include file="./layouts/header.jsp" %>
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header main-color-bg">
                        <span>Overview</span>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="info-box">
                                    <span class="info-box-icon bg-primary text-white">
                                        <i class="fa fa-user"></i>
                                    </span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">
                                            User
                                        </span>
                                        <span class="info-box-number">
                                            <% out.print(DAODashboard.counter().get("user_count")); %>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="info-box">
                                    <span class="info-box-icon bg-success text-white">
                                        <i class="fa fa-book"></i>
                                    </span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">
                                            Book
                                        </span>
                                        <span class="info-box-number">
                                            <% out.print(DAODashboard.counter().get("book_count")); %>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="info-box">
                                    <span class="info-box-icon bg-warning text-white">
                                        <i class="fa fa-align-justify"></i>
                                    </span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">
                                            Category
                                        </span>
                                        <span class="info-box-number">
                                            <% out.print(DAODashboard.counter().get("category_count")); %>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="info-box">
                                    <span class="info-box-icon bg-info text-white">
                                        <i class="fa fa-receipt"></i>
                                    </span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">
                                            Invoice
                                        </span>
                                        <span class="info-box-number">
                                            <% out.print(DAODashboard.counter().get("invoice_count")); %>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="info-box">
                                    <span class="info-box-icon bg-primary text-white">
                                        <i class="fa fa-book"></i>
                                    </span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">
                                            Sold books
                                        </span>
                                        <span class="info-box-number">
                                            <% out.print(DAODashboard.counter().get("total_sold_books")); %>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="info-box">
                                    <span class="info-box-icon bg-success text-white">
                                        <i class="fa fa-money-check-alt"></i>
                                    </span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">
                                            Total Money
                                        </span>
                                        <span class="info-box-number">
                                            <% out.print(DAODashboard.counter().get("total_money")); %>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="info-box">
                                    <span class="info-box-icon bg-warning text-white">
                                        <i class="fa fa-money-book"></i>
                                    </span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">
                                            Left book
                                        </span>
                                        <span class="info-box-number">
                                            <% out.print(DAODashboard.counter().get("total_left_books")); %>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="./layouts/footer.jsp" />
</body>

</html>