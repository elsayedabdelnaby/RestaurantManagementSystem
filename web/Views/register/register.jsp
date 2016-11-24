<%-- 
    Document   : register
    Created on : Nov 24, 2016, 7:29:53 PM
    Author     : elsayed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/css/myStyle.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="Resources/js/bootstrap.min.js"></script>
        <title>Sign Up</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Register 
                        </div>
                        <div class="panel-body">
                            <p class="error">${requestScope.error}</p>
                            <form method="post" action="register">
                                <div class="col-lg-12 form-group">
                                    <input type="text" class="form-control" placeholder="name:" name="name">
                                </div>
                                <div class="col-lg-12 form-group">
                                    <input type="text" class="form-control" placeholder="email:" name="email">
                                </div>
                                <div class="row">
                                    <div class="col-md-4" align="center">
                                        <p>Password</p>
                                    </div>
                                    <div class="col-md-8">
                                        <input type="password" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <p>Confirm Password</p>
                                    </div>
                                    <div class="col-md-8">
                                        <input type="password" class="form-control" name="confirm_password">
                                    </div>
                                </div>
                                <br>
                                <div class="col-md-3"></div>
                                <div class="col-md-6 form-group">
                                    <input type="submit" class="form-control btn btn-primary" name="register" value="Register">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
    </body>
</html>
