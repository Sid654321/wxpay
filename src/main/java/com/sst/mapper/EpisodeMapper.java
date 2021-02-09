package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.Episode;

public interface EpisodeMapper {

	public int create(Episode episode);

	public int delete(Integer id);

	public int update(Episode episode);

	public int updateSelective(Episode episode);

	public List<Episode> query(Episode episode);


	public Episode detail(Integer id);

	public int count(Episode episode);

}