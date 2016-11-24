/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rms.listeners;

import com.rms.db.ConnectionManager;
import java.sql.Connection;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author elsayed
 */
public class ConnectionListener implements ServletContextListener {

    Connection connection = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        connection = ConnectionManager.getInstance().getConnection();
        sce.getServletContext().setAttribute("DBConnection", connection);
        System.out.println("Application StartUP and Open DBConneciton");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            connection.close();
            connection = null;
            sce.getServletContext().removeAttribute("DBConnection");
            System.out.println("Application Closed and Close DBConnection");
        } catch (Exception e) {
            System.out.println("Connection Close Error:" + e.getMessage());
        }
    }
}
