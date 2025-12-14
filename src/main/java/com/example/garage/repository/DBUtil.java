package com.example.garage.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    
    private static final String URL = "jdbc:mysql://localhost:3306/garage_db"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

    /**Ouvre et retourne une nouvelle connexion à la base de données.
     * @return La connexion.
     * @throws SQLException Si une erreur de connexion survient.
     */
    public static Connection getConnection() throws SQLException {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC non trouvé.");
            throw new SQLException("Driver non trouvé", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}