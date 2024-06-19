package com.lee.service;

import com.lee.domains.ResponseResult;
import com.lee.domains.vo.UploadRequest;

public interface UploadService {
    ResponseResult uploadWork(UploadRequest uploadRequest);

    ResponseResult updateWork(UploadRequest uploadRequest);
}
