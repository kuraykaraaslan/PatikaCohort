package org.rentacar.data;


import org.rentacar.core.Database;
import org.rentacar.core.Helpers;
import org.rentacar.entities.Brand;
import org.rentacar.entities.Car;
import org.rentacar.entities.Model;
import org.rentacar.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserData {
    private final Connection connection = Database.getInstance();

    public UserData() {
        return;
    }

    public User match(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    }


    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(match(rs));
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return users;
    }

    public User get(int id) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = match(rs);
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return user;
    }

    public boolean add(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password, role) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean update(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET username = ?, password = ?, role = ? WHERE id = ?");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean delete(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }


    public User login(String username, String password) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = match(rs);
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return user;
    }
}

