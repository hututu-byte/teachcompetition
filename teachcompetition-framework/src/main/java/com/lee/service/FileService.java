package com.lee.service;

import com.lee.domains.ResponseResult;
import com.lee.domains.entity.File;

public interface FileService {
    ResponseResult saveFile(File file);
    ResponseResult getFileByWorkId(Integer workId);
}
