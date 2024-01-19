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

    p
