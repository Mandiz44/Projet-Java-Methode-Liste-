/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private DataBaseConnection() {}

    // Method to get the single connection instance
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                // Load SQLite JDBC driver
                Class.forName("org.sqlite.JDBC");
                // Establish the connection
                connection = DriverManager.getConnection("jdbc:sqlite:gestionbib.db");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new SQLException("Error establishing database connection.");
            }
        }
        return connection;
    }

    // Method to close the connection when done
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}