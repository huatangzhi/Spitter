package com.hp.dao;

import com.hp.entity.Spittle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hp on 2016/12/13.
 */
public interface SpittleRepository {

    List<Spittle> findRecentSpittles();

    List<Spittle> findSpittles(@Param("max") long max, @Param("count") int count);

    Spittle findOne(long id);

    void save(Spittle spittle);

}
