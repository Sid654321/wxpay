package com.sst.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sst.mapper.VideoMapper;
import com.sst.entity.Video;
import javax.annotation.Resource;

import com.sst.utils.PageHelperUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String,Object> queryByPage(Video video) {
        PageHelperUtils.pageHelper(video);
        List<Video> list = videoMapper.query(video);
        PageInfo<Video> pageInfo = new PageInfo<>(list);
        Map<String,Object> data = new HashMap<>();
        data.put("total_size",pageInfo.getTotal());//总条数
        data.put("total_page",pageInfo.getPages());//总页数
        data.put("current_page",video.getPage());//当前页
        data.put("data",pageInfo.getList());//数据
        return data;
    }

    public Video detail(Integer id) {
        return videoMapper.detail(id);
    }

    public int count(Video video) {
        return videoMapper.count(video);
    }
}
