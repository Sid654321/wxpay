package com.sst.service;

import com.sst.mapper.VideoOrderMapper;
import com.sst.entity.VideoOrder;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoOrderService {

    @Resource
    private VideoOrderMapper videoOrderMapper;

    public int create(VideoOrder videoOrder) {
        return videoOrderMapper.create(videoOrder);
    }

    public int delete(Integer id) {
        return videoOrderMapper.delete(id);
    }

    public int update(VideoOrder videoOrder) {
        return videoOrderMapper.update(videoOrder);
    }

    public int updateSelective(VideoOrder videoOrder) {
        return videoOrderMapper.updateSelective(videoOrder);
    }

    public List<VideoOrder> query(VideoOrder videoOrder) {
        return videoOrderMapper.query(videoOrder);
    }

    public VideoOrder detail(Integer id) {
        return videoOrderMapper.detail(id);
    }

    public int count(VideoOrder videoOrder) {
        return videoOrderMapper.count(videoOrder);
    }
}
