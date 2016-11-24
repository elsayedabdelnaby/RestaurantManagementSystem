/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rms.db;

import static com.rms.db.ConnectionProvider.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author elsayed
 */
public class ConnectionManager {

    private static ConnectionManager instance = null;
    private Connection connection = null;

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    private boolean openConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            if (openConnection()) {
                return connection;
            } else {
                return null;
            }
        }
        return null;
    }
}
