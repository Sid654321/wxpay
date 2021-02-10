package com.sst.controller;

import com.sst.entity.Video;
import com.sst.service.VideoService;
import com.sst.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Resource
    private VideoService videoService;

    @PostMapping("query_by_page")
    public Result queryByPage(@RequestBody Video video){
        Map<String, Object> map = videoService.queryByPage(video);
        return Result.success(map);
    }

}
