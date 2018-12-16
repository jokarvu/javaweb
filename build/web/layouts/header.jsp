<%-- 
    Document   : header
    Created on : Dec 16, 2018, 2:04:01 PM
    Author     : mito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.DAOCategory" %>
<%@ page import="model.Category" %>
<!DOCTYPE html>
<div class="container">
        <header class="blog-header py-3">
          <div class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-4 pt-1">
              <a class="text-muted" href="">Subscribe</a>
            </div>
            <div class="col-4 text-center">
              <a class="blog-header-logo text-dark" href="">Demin Shop</a>
            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">
              <a class="text-muted" href="">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3"><circle cx="10.5" cy="10.5" r="7.5"></circle><line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>
              </a>
              <div class="row">
                <div class="col-md-6">
                    <a class="btn btn-sm btn-outline-secondary" href="/">Sign up</a>
                </div>
                <div class="col-md-6">
                    <a class="btn btn-sm btn-outline-secondary" href="/">Login</a>
                </div>
              </div>
            </div>
          </div>
        </header>
  
        <div class="nav-scroller py-1 mb-2">
          <nav class="nav d-flex justify-content-center">
                <% DAOCategory categoriess = new DAOCategory(); %>
                <%
                    for(Category c : categoriess.getListCategory()) { 
                %>
                    <a class="p-2 text-muted" href="https://getbootstrap.com/docs/4.0/examples/blog/#"><%= c.getName() %></a>
                <%
                    }
                %>
          </nav>
        </div>
  
        <div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
          <div class="col-md-6 px-0">
            <h1 class="display-4 font-italic">Title of a longer featured blog post</h1>
            <p class="lead my-3">Multiple lines of text that form the lede, informing new readers quickly and efficiently about what's most interesting in this post's contents.</p>
            <p class="lead mb-0"><a href="https://getbootstrap.com/docs/4.0/examples/blog/#" class="text-white font-weight-bold">Continue reading...</a></p>
          </div>
        </div>