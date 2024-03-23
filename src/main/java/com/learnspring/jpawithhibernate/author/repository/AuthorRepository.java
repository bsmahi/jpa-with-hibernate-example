package com.learnspring.jpawithhibernate.author.repository;

import com.learnspring.jpawithhibernate.author.models.Author;
import com.learnspring.jpawithhibernate.author.models.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveAuthorWithBooks(Author author, List<Book> books) {
        author.setBooks(books);
        entityManager.persist(author);
    }

    public Author findAuthorById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public List<Book> findBooksByAuthor(Author author) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root).where(builder.equal(root.get("author"), author));
        return entityManager.createQuery(query).getResultList();
    }
}
