package com.library.management.controllers;

import com.library.management.entitites.Book;
import com.library.management.entitites.BookBorrowing;
import com.library.management.entitites.Category;
import com.library.management.entitites.Publisher;
import com.library.management.repositories.BookBorrowingRepository;

import com.library.management.repositories.BookRepository;

import com.library.management.repositories.CategoryRepository;

import com.library.management.repositories.PublisherRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookBorrowingRepository bookBorrowingRepository;

    @GetMapping
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        Optional<Category> category = categoryRepository.findById(book.getCategory().getId());
        Optional<Publisher> publisher = publisherRepository.findById(book.getPublisher().getId());
        if (category.isPresent() && publisher.isPresent()) {
            book.setCategory(category.get());
            book.setPublisher(publisher.get());
            return bookRepository.save(book);
        }
        return null;
    }

    @PostMapping("/borrow")
    public BookBorrowing borrow(@RequestBody BookBorrowing bookBorrowing) {
        return bookBorrowingRepository.save(bookBorrowing);
    }
}
