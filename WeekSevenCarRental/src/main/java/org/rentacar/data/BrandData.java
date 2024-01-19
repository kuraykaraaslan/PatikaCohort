package org.rentacar.data;


import org.rentacar.core.Database;
import org.rentacar.entities.Brand;
import org.rentacar.core.Helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandData {
    private final Connection connection = Database.getInstance();

    public BrandData() {
        return;
    }

    public Brand match(ResultSet rs) throws SQLException {
        Brand brand = new Brand();
        brand.setId(rs.getInt("id"));
        brand.setName(rs.getString("name"));
        return brand;
    }

    public ArrayList<Brand> getAll() {
        ArrayList<Brand> brands = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM brands");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                brands.add(match(rs));
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return brands;

    }

    public Brand get(int id) {
        Brand brand = new Brand();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM brands WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                brand = match(rs);
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return brand;
    }

    public boolean add(Brand brand) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO brands (name) VALUES (?)");
            preparedStatement.setString(1, brand.getName());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean update(Brand brand) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE brands SET name = ? WHERE id = ?");
            preparedStatement.setString(1, brand.getName());
            preparedStatement.setInt(2, brand.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM brands WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

}