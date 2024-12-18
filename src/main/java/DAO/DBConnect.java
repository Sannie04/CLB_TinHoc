package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

    // Logger to log the errors or connection status
    private static final Logger logger = Logger.getLogger(DBConnect.class.getName());

    // Database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/clb_tinhoc?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "0728012004";

    // Method to establish a connection to the database
    public static Connection getConnection() {
        try {
            // Load MySQL JDBC driver (optional in newer versions of JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");  // Corrected driver class

            // Return the connection object
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            // Log SQL errors
            logger.log(Level.SEVERE, "Database connection failed", e);
        } catch (ClassNotFoundException e) {
            // Log driver not found errors
            logger.log(Level.SEVERE, "JDBC Driver not found", e);
        }

        // Return null if connection fails
        return null;
    }

    public static void main(String[] args) {
        // Test the database connection
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            // Handle exception during connection testing
            System.out.println("Connection failed during test.");
        }
    }
}
