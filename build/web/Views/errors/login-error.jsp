<%-- 
    Document   : login
    Created on : Nov 24, 2016, 8:00:57 AM
    Author     : elsayed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/css/myStyle.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="Resources/js/bootstrap.min.js"></script>
        <title>Login</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="">Restaurant Management System</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="">Home</a></li>
                    <li><a href="#">Menus</a></li>
                    <li><a href="#">Items</a></li> 
                    <li><a href="#">Meals</a></li> 
                    <li><a href="#">Customers</a></li> 
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="/RMS/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Login
                        </div>
                        <div class="panel-body">
                            <form method="post" action="login">
                                <div class="col-lg-12 form-group">
                                    <c:if test="${!requestScope.errors.get(0).equals(null)}">
                                        <p class="error"><c:out value="${requestScope.errors.get(0)}"></c:out></p>
                                    </c:if>
                                        <input type="text" class="form-control" placeholder="user email:" name="email" value="${param.email}">
                                </div>
                                <div class="col-lg-12">
                                    <c:if test="${!requestScope.errors.get(1).equals(0)}">
                                        <p class="error"><c:out value="${requestScope.errors.get(1)}"></c:out></p>
                                    </c:if>
                                    <input type="password" class="form-control" name="password">
                                </div>
                                <div class="col-lg-3"></div>
                                <div class="col-lg-6 form-group">
                                    <input type="submit" class="form-control btn btn-primary" name="login" value="Login">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
