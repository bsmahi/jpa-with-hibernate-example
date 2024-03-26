package com.learnspring.jpawithhibernate;

import com.learnspring.jpawithhibernate.author.models.Author;
import com.learnspring.jpawithhibernate.author.models.Book;
import com.learnspring.jpawithhibernate.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private AlbumJdbcRepository repository;

//    @Autowired
//    private AlbumJpaRepository repository;

    @Autowired
    private AuthorRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        repository.create(new Album("Pursuit of Happiness", LocalDate.now().minusYears(20)));
//        repository.create(new Album("The Avatar", LocalDate.now().minusYears(10)));
//        repository.create(new Album("The Avatar 2", LocalDate.now().minusYears(2)));
//
//        System.out.println("FIND ALBUM DETAILS..." + repository.findById(1));
//        System.out.println();
//
//        System.out.println("DELETE ALBUM DETAILS FOR THE GIVEN ID...");
//        repository.deleteById(3);
//        System.out.println();
//
//        System.out.println("FIND AGAIN ALBUM DETAILS..." + repository.findById(3));
//
//        System.out.println();
//        System.out.println("UPDATE ALBUM DETAILS FOR THE GIVEN ID...");
//        repository.updateById(2, "WaveWater");
//        System.out.println();
//        System.out.println("FIND AGAIN ALBUM DETAILS AFTER UPDATE..." + repository.findById(2));
//
//        System.out.println();
//        System.out.println("FIND ALL ALBUM DETAILS" + repository.findAll());

        Author authorOne = new Author("authorOne", "descriptionOne");//1
        Author authorTwo = new Author("authorTwo", "descriptionTwo");//2

        Book bookOne = new Book("titleBookOne", "bookDescriptionOne");//1, 1
        Book bookTwo = new Book("titleBookTwo", "bookDescriptionTwo");//2, 2

        authorOne.setBooks(List.of(bookOne));
        authorTwo.setBooks(List.of(bookTwo));

        bookOne.setAuthor(authorOne);
        bookTwo.setAuthor(authorTwo);

        repository.saveAuthorWithBooks(authorOne);
        repository.saveAuthorWithBooks(authorTwo);

        repository.findAll().forEach(System.out::println);

    }
}
