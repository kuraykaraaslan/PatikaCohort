package org.rentacar.controller;


import org.rentacar.core.Helpers;
import org.rentacar.data.CarData;
import org.rentacar.entities.Car;

import java.util.ArrayList;

public class CarController {
    private final CarData carData = new CarData();

    public boolean saveCar(Car car) {
        return carData.add(car);
    }

    public Car getById(int carId) {
        return carData.get(carId);
    }

    public boolean updateCar(Car car) {
        if (carData.get(car.getId()) != null) {
            return carData.update(car);
        } else {
            Helpers.showErrorMessage("Car not found");
            return false;
        }
    }

    public boolean deleteCar(Car car) {
        if (carData.get(car.getId()) != null) {
            return carData.delete(car.getId());
        } else {
            Helpers.showErrorMessage("Car not found");
            return false;
        }
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Car> cars) {
        ArrayList<Object[]> data = new ArrayList<>();
        for (Car car : cars) {
            Object[] row = new Object[size];
            row[0] = car.getId();
            row[1] = car.getBrand().getName();
            row[2] = car.getModel().getName();
            row[3] = car.getPlate();
            row[4] = car.getColor();
            row[5] = car.getKilometers();
            row[6] = car.getModel().getYear();
            row[6] = car.getModel().getType();
            row[6] = car.getModel().getFuel();
            row[6] = car.getModel().getGear();
            data.add(row);
        }
        return data;
    }

    public ArrayList<Car> getAll() {
        return carData.getAll();
    }
}