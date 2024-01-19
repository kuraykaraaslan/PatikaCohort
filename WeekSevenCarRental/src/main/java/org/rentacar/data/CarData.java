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

public class CarData {

    private final Connection connection = Database.getInstance();
    private final BrandData brandData;
    private final ModelData modelData;

    public CarData() {
        this.brandData = new BrandData();
        this.modelData = new ModelData();
    }

    public Car match(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setBrand(brandData.get(rs.getInt("brand_id")));
        car.setModel(modelData.get(rs.getInt("model_id")));
        return car;
    }

    public ArrayList<Car> getAll() {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                cars.add(match(rs));
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return cars;
    }

    public Car get(int id) {
        Car car = new Car();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                car = match(rs);
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return car;
    }

    public boolean add(Car car) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cars (brand_id, model_id, color, kilometers, plate) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, car.getBrand().getId());
            preparedStatement.setInt(2, car.getModel().getId());
            preparedStatement.setString(3, car.getColor());
            preparedStatement.setInt(4, car.getKilometers());
            preparedStatement.setString(5, car.getPlate());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }

    }

    public boolean update(Car car) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cars SET brand_id = ?, model_id = ?, color = ?, kilometers = ?, plate = ? WHERE id = ?");
            preparedStatement.setInt(1, car.getBrand().getId());
            preparedStatement.setInt(2, car.getModel().getId());
            preparedStatement.setString(3, car.getColor());
            preparedStatement.setInt(4, car.getKilometers());
            preparedStatement.setString(5, car.getPlate());
            preparedStatement.setInt(6, car.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cars WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public ArrayList<Car> search(String str) {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars WHERE plate LIKE ? OR color LIKE ?");
            preparedStatement.setString(1, "%" + str + "%");
            preparedStatement.setString(2, "%" + str + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                cars.add(match(rs));
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return cars;
    }

    public ArrayList<Car> search(int id) {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars WHERE brand_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                cars.add(match(rs));
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return cars;
    }

}
