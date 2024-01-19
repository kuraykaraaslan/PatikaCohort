package org.rentacar.data;

import org.rentacar.core.Database;
import org.rentacar.entities.Brand;
import org.rentacar.entities.Car;
import org.rentacar.entities.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.rentacar.core.Helpers;


public class ModelData {
    
    private final Connection connection = Database.getInstance();

    public ModelData() {
        return;
    }

    public Model match(ResultSet rs) throws SQLException {
        Model model = new Model();
        model.setId(rs.getInt("id"));
        model.setName(rs.getString("name"));
        return model;
    }

    public ArrayList<Model> getAll() {
        ArrayList<Model> models = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM models");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                models.add(match(rs));
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return models;
    }

    public Model get(int id) {
        Model model = new Model();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM models WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                model = match(rs);
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return model;
    }

    public Model get(String name) {
        Model model = new Model();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM models WHERE name = ?");
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                model = match(rs);
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;        
        }
        return model;
    }

    public boolean add(Model model) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO models (name) VALUES (?)");
            preparedStatement.setString(1, model.getName());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean update(Model model) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE models SET name = ? WHERE id = ?");
            preparedStatement.setString(1, model.getName());
            preparedStatement.setInt(2, model.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM models WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }
}