package com.stackroute.musixapp.repository;

import com.stackroute.musixapp.domain.Musix;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusixRepository extends MongoRepository<Musix, Integer> {

    @Query("{name:'?0'}")
    List<Musix> findTitleByName(String name);
}
