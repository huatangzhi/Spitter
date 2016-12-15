package com.hp.dao;

import com.hp.entity.Spittle;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SpittleRepositoryTest {

    @Autowired
    private SpittleRepository spittleRepository;


    @Test
    public void testfindRecentSpittles(){
        List<Spittle> spittleList = spittleRepository.findSpittles(100000, 10);

        for(Spittle i:spittleList){
            System.out.print(i);
        }

    }

}
