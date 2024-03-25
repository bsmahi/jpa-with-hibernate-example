package com.learnspring.jpawithhibernate.author.service;

import com.learnspring.jpawithhibernate.author.models.Author;
import com.learnspring.jpawithhibernate.author.models.Book;
import com.learnspring.jpawithhibernate.author.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    // Constructor Dependency Injection
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author create(Author author) {
        return repository.saveAuthorWithBooks(author);
    }

    public Author findAuthorById(long id) {
        return repository.findAuthorById(id);
    }

    public List<Book> findBooksByAuthor(Author author) {
        return repository.findBooksByAuthor(author);
    }

    public List<Author> findAll() {
        return repository.findAll();
    }
}
