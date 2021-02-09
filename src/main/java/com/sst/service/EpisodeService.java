package com.sst.service;

import com.sst.mapper.EpisodeMapper;
import com.sst.entity.Episode;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EpisodeService {

    @Resource
    private EpisodeMapper episodeMapper;

    public int create(Episode episode) {
        return episodeMapper.create(episode);
    }

    public int delete(Integer id) {
        return episodeMapper.delete(id);
    }

    public int update(Episode episode) {
        return episodeMapper.update(episode);
    }

    public int updateSelective(Episode episode) {
        return episodeMapper.updateSelective(episode);
    }

    public List<Episode> query(Episode episode) {
        return episodeMapper.query(episode);
    }

    public Episode detail(Integer id) {
        return episodeMapper.detail(id);
    }

    public int count(Episode episode) {
        return episodeMapper.count(episode);
    }
}
