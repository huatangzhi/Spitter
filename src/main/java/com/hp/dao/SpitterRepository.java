package com.hp.dao;

import com.hp.entity.Spitter;


public interface SpitterRepository {

    /**
     * 保存用户
     *
     * @param spitter
     * @return
     */
    void save(Spitter spitter);

    /**
     * 根据姓名查询用户
     *
     * @param username
     * @return Spitter
     */
    Spitter findByUsername(String username);

}
