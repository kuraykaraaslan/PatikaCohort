package com.library.management.repositories;

import com.library.management.entitites.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByBooksId(Long bookId);
}
