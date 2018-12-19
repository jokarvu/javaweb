<%-- 
    Document   : index
    Created on : Dec 13, 2018, 10:52:46 AM
    Author     : mito
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%
    if (session.getAttribute("username") != null) {
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", "/shop/index.jsp");
    }
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="./css/bootstrap.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/app.css">
    </head>
    <body>
        <jsp:include page="./layouts/header.jsp"/>
        <!-- Main -->
        <h2 class="text-primary">Register</h2>
        <hr>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <div class="text-center">
                        <%
                            if(request.getParameter("error") != null) {
                                if(request.getParameter("error").equals("1")) {
                                    out.print("<p class='text-danger'>Mật khẩu không trùng khớp</p>");
                                }
                                if(request.getParameter("error").equals("2")) {
                                    out.print("<p class='text-danger'>Tên đăng nhập hoặc email đã tồn tại</p>");
                                }
                            }
                        %>
                        <form action="/shop/register" method="post">
                            <div class="form-group">
                                <input type="text" name="username" class="form-control" placeholder="Username">
                            </div>
                            <div class="form-group">
                                <input type="email" name="email" class="form-control" placeholder="Email">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <input type="password" name="repassword" class="form-control" placeholder="Re-enter your password">
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary">Register</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
        <!-- Footer -->
        <jsp:include page="./layouts/footer.jsp"/>
    </body>
</html>
