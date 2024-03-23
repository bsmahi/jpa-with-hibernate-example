package com.learnspring.jpawithhibernate.album.repository;

import com.learnspring.jpawithhibernate.album.models.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class AlbumJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Album album) {
        entityManager.persist(album);
    }

    public Album findById(long id) {
        return entityManager.find(Album.class, id);
    }

    public void deleteById(long id) {
        var album = entityManager.find(Album.class, id);
        entityManager.remove(album);
    }

    public void updateById(long albumId, String newTitle) {
        var albumDetails = entityManager.find(Album.class, albumId);
        if (albumDetails != null) {
            albumDetails.setTitle(newTitle);
            entityManager.merge(albumDetails);
        } else {
            throw new RuntimeException("Album not found with ID: " + albumId);
        }
    }

    // EntityManager’s createQuery method for creating dynamic queries (Java Persistence Query Language – JPQL) directly
    public List<Album> findAll() {
        TypedQuery<Album> query = entityManager.createQuery("SELECT a FROM Album a", Album.class);
        return query.getResultList();
    }
}
