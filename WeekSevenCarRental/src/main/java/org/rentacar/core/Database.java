package org.rentacar.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private static Connection connection;

    private final String url = "jdbc:postgresql://localhost:5432/rentacar";
    private final String username = "postgres";
    private final String password = "postgres";

    // Private singleton constructor
    private Database() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Public static method to get the instance
    public Connection getConnection() {
        return connection;
    }

    public static Connection getInstance(){
        try {
            if (instance == null || instance.getConnection().isClosed()){
                instance = new Database();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return instance.getConnection();
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

}
