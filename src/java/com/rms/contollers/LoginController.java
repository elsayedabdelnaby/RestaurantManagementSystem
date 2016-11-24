/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rms.contollers;

import com.rms.beans.User;
import com.rms.models.User_Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author elsayed
 */
public class LoginController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("Views/login.jsp").forward(request, response);
        } else {
            out.print("home under cinstruction");
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        ArrayList<String> errors = new ArrayList<String>();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if (email.equals("") || email.equals(null)) {
            errors.add(0, "Please Enter Email");
        } else {
            errors.add(0, null);
        }
        
        if (password.equals("") || password.equals(null)) {
            errors.add(1, "Please Enter Password");
        } else {
            errors.add(1, null);
        }
        
        if (errors.get(0) != null || errors.get(1) != null) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("Views/errors/login-error.jsp").forward(request, response);
        } else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
            if (User_Model.login(user, connection)) {
                out.println("Weclome");
            } else {
                //out.println("<script>alert('Email or Password Error,Please Try Again');</script>");
                request.setAttribute("error", "Email or Password Error,Please Try Again");
                request.getRequestDispatcher("Views/login.jsp").include(request, response);
            }
        }
    }
}
