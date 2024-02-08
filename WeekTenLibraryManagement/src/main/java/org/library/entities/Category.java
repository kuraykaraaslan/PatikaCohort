package org.library.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String name;

    @Column(name = "category_description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

    public Category() {
        books = new ArrayList<>();
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        books = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public void removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
        }
    }

    public void addBooks(List<Book> books) {
        for (Book book : books) {
            addBook(book);
        }
    }

    public void removeBooks(List<Book> books) {
        for (Book book : books) {
            removeBook(book);
        }
    }
}
