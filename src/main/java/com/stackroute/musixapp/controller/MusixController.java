package com.stackroute.musixapp.controller;

import com.stackroute.musixapp.domain.Musix;
import com.stackroute.musixapp.service.MusixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MusixController {


    private MusixService musixService;


    @Autowired
    public MusixController(MusixService musixService) {

        this.musixService = musixService;
    }

    @PostMapping("muzix")
    public ResponseEntity<?> saveNewMusix(@RequestBody Musix musix)  {
        ResponseEntity responseEntity;
        try{
            musixService.saveNewMusix(musix);
            responseEntity= new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity= new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("muzix")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<List<Musix>>(musixService.getMusix(), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("/muzix/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {

        Musix musix = musixService.getById(id);
        return new ResponseEntity<Musix>(musix, HttpStatus.OK);
    }

    @DeleteMapping("/muzix/{id}")
    public String deleteMusix(@PathVariable int id) {
        musixService.deleteById(id);
        return "Data deleted";
    }

    @PutMapping("/muzix/{id}")
    public String updateMusix(@RequestBody Musix musix, @PathVariable int id) {

        musixService.updateById(musix, id);
        return "Song Updated!";
    }

    @GetMapping("/muzix/{name}")
    public ResponseEntity<List<Musix>> getByname(@PathVariable String name) {
        List<Musix> musix = musixService.getByName(name);
        return new ResponseEntity<List<Musix>>(musix, HttpStatus.OK);
    }

}
