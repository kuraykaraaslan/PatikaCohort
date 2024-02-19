package com.library.management.services;

import java.util.Optional;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.library.management.entitites.Author;
import com.library.management.entitites.Book;

import com.library.management.repositories.AuthorRepository;
import com.library.management.repositories.BookRepository;


@Service
@RequiredArgsConstructor
public class AuthorService {
    
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Book> findBooksByAuthorId(Long id) {
        return bookRepository.findByAuthorId(id);
    }

    public List<Author> findByBooksId(Long id) {
        return authorRepository.findByBooksId(id);
    }
}


