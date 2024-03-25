package com.learnspring.jpawithhibernate.author.models;

import jakarta.persistence.*;

@Entity
@Table(name = "BOOK_DETAILS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BOOK_TITLE")
    private String title;

    @Column(name = "BOOK_DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Constructors
    public Book() {
    }

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
