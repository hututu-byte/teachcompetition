package com.lee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Video;
import com.lee.mapper.VideoMapper;
import com.lee.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public ResponseResult saveVideo(Video video) {
        videoMapper.insert(video);
        return ResponseResult.okResult(video);
    }

    @Override
    public ResponseResult getVideosByWorkId(Integer workId) {
        List<Video> videos = videoMapper.selectList(new QueryWrapper<Video>().eq("work_id", workId));
        return ResponseResult.okResult(videos);
    }
}
