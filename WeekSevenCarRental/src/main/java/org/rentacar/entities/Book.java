package org.rentacar.entities;

import java.sql.Date;

public class Book {
    private int id;
    private Car car;

    private String full_name;
    private String email;
    private String phone;

    private int citizenship_id;

    private Date start_date;
    private Date end_date;

    private String book_case;

    private String note;

    private int price;


    public Book(Car car, String full_name, String email, String phone, int citizenship_id, String mp_number, Date start_date, Date end_date, String book_case, String note, int price) {
        this.car = car;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.citizenship_id = citizenship_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.book_case = book_case;
        this.note = note;
        this.price = price;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public String getFullName() {
        return full_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getCitizenshipId() {
        return citizenship_id;
    }


    public Date getStartDate() {
        return start_date;
    }

    public Date getEndDate() {
        return end_date;
    }

    public String getBookCase() {
        return book_case;
    }

    public String getNote() {
        return note;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCitizenshipId(int citizenship_id) {
        this.citizenship_id = citizenship_id;
    }

    public void setStartDate(Date start_date) {
        this.start_date = start_date;
    }

    public void setEndDate(Date end_date) {
        this.end_date = end_date;
    }

    public void setBookCase(String book_case) {
        this.book_case = book_case;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCarPlate() {
        return car.getPlate();
    }

    public String getCarBrand() {
        return car.getBrand().getName();
    }

    public String getCarColor() {
        return car.getColor().toString();
    }

    public int getCarKilometers() {
        return car.getKilometers();
    }

    public String getStartDateString() {
        return start_date.toString();
    }

    public int getEndDateString() {
        return end_date.getDate();
    }

    public String toString() {
        return "Book{" +
                "id=" + id +
                ", car=" + car +
                ", full_name='" + full_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", citizenship_id=" + citizenship_id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", book_case='" + book_case + '\'' +
                ", note='" + note + '\'' +
                ", price=" + price +
                '}';
    }

    public void setBookID(String text) {
    }

}
