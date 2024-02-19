package com.library.management.controllers;

import com.library.management.entitites.BookBorrowing;
import com.library.management.services.BookBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrow")

public class BorrowingController {

    @Autowired
    private BookBorrowingService bookBorrowingService;

    @GetMapping
    public List<BookBorrowing> findAll() {
        return bookBorrowingService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BookBorrowing> findById(@PathVariable Long id) {
        return bookBorrowingService.findById(id);
    }

    @PostMapping
    public BookBorrowing save(@RequestBody BookBorrowing bookBorrowing) {
        return bookBorrowingService.save(bookBorrowing);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookBorrowingService.deleteById(id);
    }
}

