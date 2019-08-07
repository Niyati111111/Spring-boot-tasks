package com.stackroute.musixapp.service;

import com.stackroute.musixapp.domain.Musix;
import com.stackroute.musixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixapp.exceptions.TrackNotFoundException;


import java.util.List;

public interface MusixService {

    public Musix saveNewMusix(Musix musix) throws TrackAlreadyExistsException;

    public List<Musix> getMusix() throws TrackNotFoundException;

    public Musix getById(int id) throws TrackNotFoundException;

    public List<Musix> deleteById(int id) throws TrackNotFoundException;

    public Musix updateById(Musix musix, int id) throws TrackNotFoundException;

    public List<Musix> getByName(String name) throws TrackNotFoundException;

}
