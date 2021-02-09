package com.sst.service;

import com.sst.mapper.ChapterMapper;
import com.sst.entity.Chapter;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public int create(Chapter chapter) {
        return chapterMapper.create(chapter);
    }

    public int delete(Integer id) {
        return chapterMapper.delete(id);
    }

    public int update(Chapter chapter) {
        return chapterMapper.update(chapter);
    }

    public int updateSelective(Chapter chapter) {
        return chapterMapper.updateSelective(chapter);
    }

    public List<Chapter> query(Chapter chapter) {
        return chapterMapper.query(chapter);
    }

    public Chapter detail(Integer id) {
        return chapterMapper.detail(id);
    }

    public int count(Chapter chapter) {
        return chapterMapper.count(chapter);
    }
}
