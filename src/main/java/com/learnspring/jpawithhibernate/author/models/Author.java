package com.learnspring.jpawithhibernate.author.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTHOR_DETAILS")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private long id;

    @Column(name = "author_name")
    private String name;

    @Column(name = "author_description")
    private String description;

    // mappedBy="author" This attribute specifies the field in the related entity (the "many" side of the relationship) that owns the relationship
    // CascadeType.PERSIST means that persisting the owning entity will also persist the associated entities
    // CascadeType.MERGE means that merging the owning entity will also merge the associated entities.
    // The CascadeType.REMOVE strategy is useful for the @OneToMany and @OneToOne associations only.
    // orphanRemoval = true > will delete the child entries, if we delete the parent entity record
    // orphanRemoval = false > update the child entries
    @OneToMany(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    // Constructors
    public Author() {
    }

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", books=" + books +
                '}';
    }
}
