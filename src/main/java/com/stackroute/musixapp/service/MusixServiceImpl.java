package com.stackroute.musixapp.service;

import com.stackroute.musixapp.domain.Musix;
import com.stackroute.musixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixapp.exceptions.TrackNotFoundException;
import com.stackroute.musixapp.repository.MusixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusixServiceImpl implements MusixService, ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

    private MusixRepository musixRepository;

    @Autowired
    public MusixServiceImpl(MusixRepository musixRepository) {
       this.musixRepository = musixRepository;
    }

    @Override
    public Musix saveNewMusix(Musix musix) throws TrackAlreadyExistsException {
        if(musixRepository.existsById(musix.getId())){
            throw new TrackAlreadyExistsException("Track already exists!");
        }
        Musix savedTrack = musixRepository.save(musix);
        if(savedTrack == null) {
            throw new TrackAlreadyExistsException("Track already exists!");
        }
        return savedTrack;
    }

    @Override
    public List<Musix> getMusix() throws TrackNotFoundException {
        List<Musix> musixList = musixRepository.findAll();
        if(musixList.isEmpty()){
            throw new TrackNotFoundException("Tracks not found");
        }
        return musixList;
    }

    @Override
    public Musix getById(int id) throws TrackNotFoundException{
        Optional<Musix> userId = musixRepository.findById(id);
        if(userId.isEmpty()){
            throw new TrackNotFoundException("Track not found!");
        }
        return userId.get();
    }

    @Override
    public List<Musix> deleteById(int id) throws TrackNotFoundException {
        Optional<Musix> userId = musixRepository.findById(id);
        if(userId.isEmpty()){
            throw new TrackNotFoundException("Track not found!");
        }
        musixRepository.deleteById(id);
        return musixRepository.findAll();
    }

    @Override
    public Musix updateById(Musix musix,int id) throws TrackNotFoundException {
        Optional<Musix> userOptional = musixRepository.findById(id);

        if(userOptional.isEmpty()){
            throw new TrackNotFoundException("Track not found!");
        }

        musix.setId(id);

        musixRepository.save(musix);
        return userOptional.get();
    }

    @Override
    public List<Musix> getByName(String name) throws TrackNotFoundException{
        List<Musix> userId = musixRepository.findTitleByName(name);
        if(userId.isEmpty()){
            throw new TrackNotFoundException("Track not found!");
        }
        return userId;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        musixRepository.save(new Musix(1, "all of me", 5, "wow"));
        musixRepository.save(new Musix(2, "DNA", 5, "wow"));
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
