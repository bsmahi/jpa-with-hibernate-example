package com.learnspring.jpawithhibernate.album.repository;

import com.learnspring.jpawithhibernate.album.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlbumJdbcRepository {

    private static final String INSERT_QUERY =
            """
                        insert into album_details (title, release_date)
                        values(?,?);
                    """;
    private static final String SELECT_QUERY =

            """
                        select * from album_details
                        where id = ?
                        
                    """;


    private static final String DELETE_QUERY =

            """
                        delete from album_details
                        where id = ?
                        
                    """;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Album album) {
        System.out.println("INSIDE create");
        jdbcTemplate.update(INSERT_QUERY, album.getTitle(), album.getReleaseDate());
    }

    public Album findById(long id) {
        // ResultSet -> Bean => Row Mapper =>
        return jdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Album.class), id);
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
}
