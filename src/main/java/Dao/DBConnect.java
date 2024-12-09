package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConnection() {
        
        final String url = "jdbc:mysql://localhost:3306/hello?useUnicode=true&characterEncoding=UTF-8";
        final String user = "root"; 
        final String password = "H@120524"; 

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");  // Corrected driver class
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connected!");
        } else {
            System.out.println("Fail!");
        }
    }
}
