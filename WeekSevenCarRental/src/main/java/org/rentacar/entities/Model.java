package org.rentacar.entities;

import org.rentacar.core.ComboItem;

public class Model {
    private int id;
    private String name;
    private String description;

    private Type type;

    private Fuel fuel;

    private Gear gear;

    private Brand brand;

    private int year;

    public enum Fuel{
        GASOLINE,
        LPG,
        ELECTRIC,
        DIESEL
    }

    public enum Gear{
        MANUEL,
        AUTO
    }

    public enum Type{
        SEDAN,
        HATCHBACK
    }

    public Model(Brand brand, String name, String description, Type type, Fuel fuel, Gear gear, int year) {
        this.brand = brand;
        this.name = name;
        this.description = description;
        this.type = type;
        this.fuel = fuel;
        this.gear = gear;
        this.year = year;
    }

    public Model() {
    }

    public int getBrandId() {
        return brand.getId();
    }

    public Brand getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public Gear getGear() {
        return gear;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public int getYear() {
        return year;
    }

    public String getYearString() {
        return String.valueOf(year);
    }
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", brandId=" + brand.getId() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", fuel='" + fuel + '\'' +
                ", gear='" + gear + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setYear(String year) {
        this.year = Integer.parseInt(year);
    }


    public ComboItem getComboItem(){
        return new ComboItem(this.id, this.brand.getName() + " - " + this.name + " - " + this.year + " - " + this.type + " - " + this.fuel + " - " + this.gear);
    }
}
