package edu.neu.birds.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.neu.birds.dao.BirdDao;
import edu.neu.birds.dao.ImageDao;
import edu.neu.birds.entity.Bird;
import edu.neu.birds.entity.Image;
import edu.neu.birds.pojo.BirdInfo;
import edu.neu.birds.pojo.ImageInfo;
import edu.neu.birds.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class BirdServiceImpl implements BirdService {

    @Autowired
    private BirdDao birdDao;

    @Autowired
    private ImageDao imageDao;

    @Override
    public List<BirdInfo> list() {
        List<Bird> birds = birdDao.findAll();
        List<Long> imageIds = birds.stream().map(Bird::getImageId).collect(Collectors.toList());
        List<Image> images = imageDao.findAllByIds(imageIds);
        return buildBirdInfos(birds, images);
    }

    private List<BirdInfo> buildBirdInfos(List<Bird> birds, List<Image> images) {
        Map<Long, ImageInfo> birdToImage = Maps.newHashMap();
        images.forEach(image -> birdToImage.put(image.getBirdId(), new ImageInfo(image.getId(), image.getUrl())));

        List<BirdInfo> birdInfos = Lists.newArrayList();
        birds.forEach(bird -> {
            BirdInfo birdInfo = new BirdInfo(bird.getId(), bird.getName(), bird.getDescription(), Lists.newArrayList(birdToImage.get(bird.getId())));
            birdInfos.add(birdInfo);
        });
        return birdInfos;
    }

    @Override
    public BirdInfo find(long birdId) {
        Bird bird = birdDao.findBirdById(birdId);
        List<Image> images = imageDao.findAllByBirdId(birdId);
        List<ImageInfo> imageInfos = Lists.newArrayList();
        images.forEach(image -> imageInfos.add(new ImageInfo(image.getId(), image.getUrl())));
        return new BirdInfo(birdId, bird.getName(), bird.getDescription(), imageInfos);
    }
}
