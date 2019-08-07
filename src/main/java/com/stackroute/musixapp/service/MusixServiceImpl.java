package com.stackroute.musixapp.service;

import com.stackroute.musixapp.domain.Musix;
import com.stackroute.musixapp.repository.MusixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusixServiceImpl implements MusixService {

    private MusixRepository musixRepository;

    @Autowired
    public MusixServiceImpl(MusixRepository musixRepository) {
       this.musixRepository = musixRepository;
    }

    @Override
    public Musix saveNewMusix(Musix musix) {
        Musix musix1 = musixRepository.save(musix);
        return musix1;
    }

    @Override
    public List<Musix> getMusix() {
        return musixRepository.findAll();
    }

    @Override
    public Musix getById(int id) {
        Optional<Musix> userId = musixRepository.findById(id);
        return userId.get();
    }

    @Override
    public boolean deleteById(int id) {
        musixRepository.deleteById(id);
        return true;
    }

    @Override
    public Musix updateById(Musix musix, int id) {
        Optional<Musix> userOptional = musixRepository.findById(id);

        if (!userOptional.isPresent())
            return false;

        musix.setId(id);

        musixRepository.save(musix);
        return musix;
    }


}
