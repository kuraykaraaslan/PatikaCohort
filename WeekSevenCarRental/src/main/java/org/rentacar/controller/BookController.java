package org.rentacar.controller;

import org.rentacar.core.Helpers;
import org.rentacar.data.BookData;
import org.rentacar.entities.Book;

import java.util.ArrayList;

import org.rentacar.entities.Book;

public class BookController {
    private final BookData bookData;

    public BookController() {
        this.bookData = new BookData();
    }

    public boolean saveBook(Book book) {
        return bookData.add(book);
    }

    public Book getById(int bookId) {
        return bookData.get(bookId);
    }

    public boolean updateBook(Book book) {
        if (bookData.get(book.getId()) != null) {
            return bookData.update(book);
        } else {
            Helpers.showErrorMessage("Book not found");
            return false;
        }
    }

    public boolean deleteBook(Book book) {
        if (bookData.get(book.getId()) != null) {
            return bookData.delete(book.getId());
        } else {
            Helpers.showErrorMessage("Book not found");
            return false;
        }
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Book> books) {
        ArrayList<Object[]> data = new ArrayList<>();
        for (Book book : books) {
            Object[] row = new Object[size];
            row[0] = book.getId();
            row[1] = book.getCar().getBrand().getName();
            row[2] = book.getCar().getModel().getName();
            row[3] = book.getCar().getPlate();
            row[4] = book.getCar().getColor();
            row[5] = book.getCar().getKilometers();
            row[6] = book.getCar().getModel().getYear();
            row[7] = book.getCar().getModel().getType();
            row[8] = book.getCar().getModel().getFuel();
            row[9] = book.getCar().getModel().getGear();
        }
    }
