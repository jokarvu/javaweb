<%-- 
    Document   : index
    Created on : Dec 13, 2018, 10:52:46 AM
    Author     : mito
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.DAOCategory" %>
<%@ page import="model.Category" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="./layouts/header.jsp"/>
    </head>
    <body>
        <% DAOCategory categoriess = new DAOCategory(); %>
        <%
            for(Category c : categoriess.getListCategory()) { 
        %>
        <h1><%= c.getName() %></h1>
        <h1><%= c.getCreated_at() %></h1>
        <h1><%= c.getUpdated_at() %></h1>
        <%
            }
        %>
        <button class="btn btn-danger">ok</button>
    </body>
</html>
