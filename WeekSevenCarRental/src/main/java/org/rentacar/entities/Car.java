package org.rentacar.entities;

public class Car {
    private int id;

    private int brandId;

    Color color;

    private int kilometers;

    private String plate;

    private Brand brand;

    private Model model;


    public enum Color {
        RED,
        BLUE,
        GREEN,
        BLACK,
        WHITE
    }


    public Car(int brandId, Color color, int kilometers, String plate) {
        this.brandId = brandId;
        this.color = color;
        this.kilometers = kilometers;
        this.plate = plate;
    }

    public Car() {
    }

    public int getBrandId() {
        return brandId;
    }

    public String getColor() {
        return color.toString();
    }

    public int getKilometers() {
        return kilometers;
    }

    public String getPlate() {
        return plate;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", color=" + color +
                ", kilometers=" + kilometers +
                ", plate='" + plate + '\'' +
                '}';
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

}
