package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.VideoOrder;

public interface VideoOrderMapper {

	public int create(VideoOrder videoOrder);

	public int delete(Integer id);

	public int update(VideoOrder videoOrder);

	public int updateSelective(VideoOrder videoOrder);

	public List<VideoOrder> query(VideoOrder videoOrder);


	public VideoOrder detail(Integer id);

	public int count(VideoOrder videoOrder);

}