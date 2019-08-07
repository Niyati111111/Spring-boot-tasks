package com.stackroute.musixapp.service;

import com.stackroute.musixapp.domain.Musix;

import java.util.List;

public interface MusixService {

    public Musix saveNewMusix(Musix musix);

    public List<Musix> getMusix();

    public Musix getById(int id);

    public List<Musix> deleteById(int id);

    public Musix updateById(Musix musix, int id);

    public List<Musix> getByName(String name);

}
