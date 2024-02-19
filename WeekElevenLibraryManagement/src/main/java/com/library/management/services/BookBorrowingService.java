package com.library.management.services;

import com.library.management.entitites.BookBorrowing;
import com.library.management.repositories.BookBorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookBorrowingService {

    @Autowired
    private BookBorrowingRepository bookBorrowingRepository;

    public List<BookBorrowing> findAll() {
        return bookBorrowingRepository.findAll();
    }

    public Optional<BookBorrowing> findById(Long id) {
        return bookBorrowingRepository.findById(id);
    }

    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return bookBorrowingRepository.save(bookBorrowing);
    }

    public void deleteById(Long id) {
        bookBorrowingRepository.deleteById(id);
    }
}

