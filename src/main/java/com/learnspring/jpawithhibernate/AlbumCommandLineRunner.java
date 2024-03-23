package com.learnspring.jpawithhibernate;

import com.learnspring.jpawithhibernate.album.models.Album;
import com.learnspring.jpawithhibernate.album.repository.AlbumJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AlbumCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private AlbumJdbcRepository repository;

    @Autowired
    private AlbumJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.create(new Album("Pursuit of Happiness", LocalDate.now().minusYears(20)));
        repository.create(new Album("The Avatar", LocalDate.now().minusYears(10)));
        repository.create(new Album("The Avatar 2", LocalDate.now().minusYears(2)));

        System.out.println("FIND ALBUM DETAILS..." + repository.findById(1));
        System.out.println();

        System.out.println("DELETE ALBUM DETAILS FOR THE GIVEN ID...");
        repository.deleteById(3);
        System.out.println();

        System.out.println("FIND AGAIN ALBUM DETAILS..." + repository.findById(3));

        System.out.println();
        System.out.println("UPDATE ALBUM DETAILS FOR THE GIVEN ID...");
        repository.updateById(2, "WaveWater");
        System.out.println();
        System.out.println("FIND AGAIN ALBUM DETAILS AFTER UPDATE..." + repository.findById(2));

        System.out.println();
        System.out.println("FIND ALL ALBUM DETAILS" + repository.findAll());

    }
}
