package org.rentacar.data;

import org.rentacar.core.Helpers;
import org.rentacar.entities.Book;
import org.rentacar.entities.Car;

import java.sql.*;
import java.util.ArrayList;
import org.rentacar.core.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookData {
    private final Connection connection = Database.getInstance();

    public BookData() {
        return;
    }

    public Book match(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        CarData carData = new CarData();
        Car car = carData.get(rs.getInt("car_id"));
        book.setCar(car);
        book.setFullName(rs.getString("full_name"));
        book.setEmail(rs.getString("email"));
        book.setPhone(rs.getString("phone"));
        book.setCitizenshipId(rs.getInt("citizenship_id"));
        book.setMpNumber(rs.getString("mp_number"));
        book.setStartDate(rs.getDate("start_date"));
        book.setEndDate(rs.getDate("end_date"));
        book.setBookCase(rs.getString("book_case"));
        book.setNote(rs.getString("note"));
        book.setPrice(rs.getInt("price"));
        return book;
    }

    public VZ<Book> getAll() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                books.add(match(rs));
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return books;

    }

    public Book get(int id) {
        Book book = new Book();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                book = match(rs);
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return book;
    }

    public boolean add(Book book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (car_id, full_name, email, phone, citizenship_id, mp_number, start_date, end_date, book_case, note, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, book.getCar().getId());
            preparedStatement.setString(2, book.getFullName());
            preparedStatement.setString(3, book.getEmail());
            preparedStatement.setString(4, book.getPhone());
            preparedStatement.setInt(5, book.getCitizenshipId());
            preparedStatement.setString(6, book.getMpNumber());
            preparedStatement.setDate(7, book.getStartDate());
            preparedStatement.setString(9, book.getBookCase());
            preparedStatement.setString(10, book.getNote());
            preparedStatement.setInt(11, book.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }

        return true;
    }

    public boolean update(Book book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE books SET car_id = ?, full_name = ?, email = ?, phone = ?, citizenship_id = ?, mp_number = ?, start_date = ?, end_date = ?, book_case = ?, note = ?, price = ? WHERE id = ?");
            preparedStatement.setInt(1, book.getCar().getId());
            preparedStatement.setString(2, book.getFullName());
            preparedStatement.setString(3, book.getEmail());
            preparedStatement.setString(4, book.getPhone());
            preparedStatement.setInt(5, book.getCitizenshipId());
            preparedStatement.setString(6, book.getMpNumber());
            preparedStatement.setDate(7, book.getStartDate());
            preparedStatement.setString(9, book.getBookCase());
            preparedStatement.setString(10, book.getNote());
            preparedStatement.setInt(11, book.getPrice());
            preparedStatement.setInt(12, book.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean delete(Book book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books WHERE id = ?");
            preparedStatement.setInt(1, book.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return false;
        }
    }

    public ArrayList<Book> search(String keyword) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE full_name LIKE ? OR email LIKE ? OR phone LIKE ? OR mp_number LIKE ? OR book_case LIKE ? OR note LIKE ?");
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");
            preparedStatement.setString(3, "%" + keyword + "%");
            preparedStatement.setString(4, "%" + keyword + "%");
            preparedStatement.setString(5, "%" + keyword + "%");
            preparedStatement.setString(6, "%" + keyword + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                books.add(match(rs));
            }
        } catch (SQLException e) {
            Helpers.showErrorMessage(e.getMessage());
            return null;
        }
        return books;
    }

}
