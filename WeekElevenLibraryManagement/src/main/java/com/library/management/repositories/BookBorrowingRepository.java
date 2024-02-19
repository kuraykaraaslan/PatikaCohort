package com.library.management.repositories;

import com.library.management.entitites.BookBorrowing;  

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowingRepository extends JpaRepository<BookBorrowing, Long> {

}

