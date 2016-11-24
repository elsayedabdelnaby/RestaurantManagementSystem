/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rms.models;

import com.rms.beans.User;
import com.rms.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author elsayed
 */
public class User_Model {

    public static boolean login(User user, Connection connection) {
        try {
            String SQL = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement statement = DBUtil.getPreparedStatement(connection, SQL);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("DB Exception " + ex.getMessage());
            return false;
        }
    }
}
