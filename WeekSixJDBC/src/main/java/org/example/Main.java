package org.example;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.lang.String;

public class Main {

    static String url = "jdbc:postgresql://localhost:5432/";
    static String user = "postgres";
    static String password = "postgres";

    static String databaseName = "employees";

    static  Connection conn = null;
    public static void main(String[] args) {


        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);

            // create a statement object to send to the database
            Statement statement = conn.createStatement();

            // create a employees database
            statement.executeUpdate("CREATE DATABASE " + databaseName);

            // Create a table in the database
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS employees (id SERIAL PRIMARY KEY, name VARCHAR(50), position VARCHAR(50), salary DECIMAL(10,2))");

            // insert data into the database
            statement.executeUpdate("INSERT INTO employees (name, position, salary) VALUES ('John Doe', 'Manager', 3500.00)");
            statement.executeUpdate("INSERT INTO employees (name, position, salary) VALUES ('Bill Smith', 'Salesman', 2000.00)");
            statement.executeUpdate("INSERT INTO employees (name, position, salary) VALUES ('Mary Jones', 'Salesman', 2000.00)");
            statement.executeUpdate("INSERT INTO employees (name, position, salary) VALUES ('Debbie Davis', 'Secretary', 1500.00)");
            statement.executeUpdate("INSERT INTO employees (name, position, salary) VALUES ('Richard Roe', 'Salesman', 2000.00)");
            statement.executeUpdate("INSERT INTO employees (name, position, salary) VALUES ('Susan Smith', 'Secretary', 1500.00)");

            // query the database
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            // display the results
            while (resultSet.next()) {
                System.out.printf("%d %s %s %.2f\n",
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("position"),
                        resultSet.getDouble("salary"));
            }

            // close the connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error accessing database.");
        }
    }
}



