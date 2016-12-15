package com.hp.dao;


import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hp.entity.Spitter;
import com.hp.dao.SpitterRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SpitterRepositoryTest {

    @Autowired
    private SpitterRepository spitterRepository;

    @Test
    public void  testfindByUsername(){
        String username = "hp";
        Spitter spitter = spitterRepository.findByUsername(username);
        System.out.println(spitter);
    }

    @Test
    public void testSpittersave(){
        Spitter savespitter = new Spitter("hr","hw","hw","hw","hw");
        spitterRepository.save(savespitter);
        System.out.print(savespitter);
    }

}
