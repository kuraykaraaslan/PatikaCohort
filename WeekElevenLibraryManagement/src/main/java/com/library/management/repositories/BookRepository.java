package com.library.management.repositories;

import com.library.management.entitites.Book;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    //findByAuthorId

    public List<Book> findByAuthorId(Long authorId);   

}


