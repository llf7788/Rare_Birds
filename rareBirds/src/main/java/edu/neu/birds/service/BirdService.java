package edu.neu.birds.service;

import edu.neu.birds.pojo.BirdInfo;

import java.util.List;

public interface BirdService {

    public List<BirdInfo> list();

    public BirdInfo find(long birdId);
}
