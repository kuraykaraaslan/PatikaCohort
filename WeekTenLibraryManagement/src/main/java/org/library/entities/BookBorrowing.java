package org.library.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id")
    private Long id;

    @Column(name = "borrowing_name", nullable = false)
    private String name;

    @Column(name = "borrowing_start_date", nullable = false)
    private Date startDate;

    @Column(name = "borrowing_return_date", nullable = false)
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "borrowing_book_id", referencedColumnName = "book_id")
    private Book book;

    // Constructors
    public BookBorrowing() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
