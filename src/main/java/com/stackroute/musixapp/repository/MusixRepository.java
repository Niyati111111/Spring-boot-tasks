package com.stackroute.musixapp.repository;

import com.stackroute.musixapp.domain.Musix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MusixRepository extends JpaRepository<Musix, Integer> {

    @Query(value = "SELECT * FROM Musix where name = ?",
            nativeQuery = true )
     List<Musix> findTitleByName(String name);
}
