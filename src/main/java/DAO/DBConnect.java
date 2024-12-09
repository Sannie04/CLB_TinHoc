package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    
    // Method to establish a connection to the database
    public static Connection getConnection() {
        // Database URL, username, and password
        final String url = "jdbc:mysql://localhost:3306/test";
        final String user = "root"; 
        final String password = "0728012004"; 

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");  // Corrected driver class
            // Return the connection object
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // Handle SQL errors
            System.out.println("Database connection failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Handle driver not found errors
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        }
        // Return null if connection fails
        return null;
    }

    public static void main(String[] args) {
        // Test the database connection
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connected!");
        } else {
            System.out.println("Fail!");
        }
    }
}
