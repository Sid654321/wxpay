package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.Video;

public interface VideoMapper {

	public int create(Video video);

	public int delete(Integer id);

	public int update(Video video);

	public int updateSelective(Video video);

	public List<Video> query(Video video);


	public Video detail(Integer id);

	public int count(Video video);

}