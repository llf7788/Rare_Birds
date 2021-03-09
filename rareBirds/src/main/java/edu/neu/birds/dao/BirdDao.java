package edu.neu.birds.dao;


import edu.neu.birds.entity.Bird;

import java.util.List;

public interface BirdDao {

    public Bird findBirdById(long id);

    public List<Bird> findAll();

}
