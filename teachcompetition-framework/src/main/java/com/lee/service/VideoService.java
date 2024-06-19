package com.lee.service;

import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Video;

public interface VideoService {
    ResponseResult saveVideo(Video video);
    ResponseResult getVideosByWorkId(Integer workId);
}
