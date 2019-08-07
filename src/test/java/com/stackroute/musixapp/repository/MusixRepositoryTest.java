package com.stackroute.musixapp.repository;

import com.stackroute.musixapp.domain.Musix;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MusixRepositoryTest {

    @Autowired
    MusixRepository musixRepository;
    Musix musix;

    @Before
    public void setUp() {
        musix = new Musix();
        musix.setId(18);
        musix.setName("mansion");
        musix.setRating(5);
        musix.setComments("wow!");
    }

    @After
    public void tearDown() {

        musixRepository.deleteAll();
    }


    @Test
    public void testSaveUser() {
        musixRepository.save(musix);
        Musix fetchUser = musixRepository.findById(musix.getId()).get();
        Assert.assertEquals(18, fetchUser.getId());

    }

    @Test
    public void testSaveUserFailure() {
        Musix testMusix = new Musix(3, "Monster", 5, "wow");
        musixRepository.save(musix);
        Musix fetchUser = musixRepository.findById(musix.getId()).get();
        Assert.assertNotSame(testMusix, musix);
    }

    @Test
    public void testGetAllUser() {
        Musix musix = new Musix(4,"Run",5,"amazing");
        Musix musix1 = new Musix(5,"Idol",5,"wow");
        musixRepository.save(musix);
        musixRepository.save(musix1);

        List<Musix> list = musixRepository.findAll();
        Assert.assertEquals("Run", list.get(0).getName());


    }

    @Test
    public void testGetTrackByIdFailure(){

        Musix track1 = new Musix(25,"Bad guy",5,"wow");
        Musix track2 = new Musix(35,"old town road",5,"good");
        musixRepository.save(track1);
        musixRepository.save(track2);
        List<Musix> list = musixRepository.findAll();
        Assert.assertNotEquals("Bad",list.get(0).getName());

    }



}
