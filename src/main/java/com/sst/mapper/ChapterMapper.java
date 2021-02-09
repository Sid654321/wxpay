package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.Chapter;

public interface ChapterMapper {

	public int create(Chapter chapter);

	public int delete(Integer id);

	public int update(Chapter chapter);

	public int updateSelective(Chapter chapter);

	public List<Chapter> query(Chapter chapter);


	public Chapter detail(Integer id);

	public int count(Chapter chapter);

}