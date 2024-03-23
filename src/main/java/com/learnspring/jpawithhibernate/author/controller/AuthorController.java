package com.learnspring.jpawithhibernate.author.controller;

import com.learnspring.jpawithhibernate.author.models.Author;
import com.learnspring.jpawithhibernate.author.models.Book;
import com.learnspring.jpawithhibernate.author.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthorService service;

    // Constructor Dependency Injection
    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping("/author")
    @Operation(summary = "Create Author with Book Details")
    public ResponseEntity<Void> saveAuthorWithBooks(@RequestBody Author author, @RequestBody List<Book> books) {
        service.create(author, books);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/author/{id}")
    @Operation(summary = "Find AuthorDetails By Id")
    public ResponseEntity<Author> findAuthorById(@PathVariable Long id) {
        Author author = service.findAuthorById(id);
        return ResponseEntity.ok(author);
    }

    @GetMapping("/author/{id}/books")
    @Operation(summary = "Find BookDetails By Id")
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable Long id) {
        Author author = service.findAuthorById(id);
        List<Book> books = service.findBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }
}
