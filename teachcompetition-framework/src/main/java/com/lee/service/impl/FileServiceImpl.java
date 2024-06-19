package com.lee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lee.domains.ResponseResult;
import com.lee.domains.entity.File;
import com.lee.mapper.FileMapper;
import com.lee.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public ResponseResult saveFile(File file) {
        fileMapper.insert(file);
        return ResponseResult.okResult(file);
    }

    @Override
    public ResponseResult getFileByWorkId(Integer workId) {
        List<File> files = fileMapper.selectList(new QueryWrapper<File>().eq("work_id", workId));
        return ResponseResult.okResult(files);
    }
}
