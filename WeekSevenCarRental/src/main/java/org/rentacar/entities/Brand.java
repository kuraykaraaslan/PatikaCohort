package org.rentacar.entities;

public class Brand {
    private int id;
    private String name;

    public Brand(String name) {
        this.name = name;
    }

    public Brand() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) { this.name = name; }

    public void setId(int id) { this.id = id; }

    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
