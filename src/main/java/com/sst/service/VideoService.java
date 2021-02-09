package com.sst.service;

import com.sst.mapper.VideoMapper;
import com.sst.entity.Video;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoService {

    @Resource
    private VideoMapper videoMapper;

    public int create(Video video) {
        return videoMapper.create(video);
    }

    public int delete(Integer id) {
        return videoMapper.delete(id);
    }

    public int update(Video video) {
        return videoMapper.update(video);
    }

    public int updateSelective(Video video) {
        return videoMapper.updateSelective(video);
    }

    public List<Video> query(Video video) {
        return videoMapper.query(video);
    }

    public Video detail(Integer id) {
        return videoMapper.detail(id);
    }

    public int count(Video video) {
        return videoMapper.count(video);
    }
}
