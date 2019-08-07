package com.stackroute.musixapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Musix {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int rating;
    private String comments;


}