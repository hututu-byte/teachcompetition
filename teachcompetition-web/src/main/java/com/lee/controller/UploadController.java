package com.lee.controller;

import com.lee.domains.ResponseResult;
import com.lee.domains.vo.UploadRequest;
import com.lee.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/work")
public class UploadController {

    @Autowired
    private UploadService uploadService;


    //---------------------------------作品上传------------------------
    @PostMapping("/upload")
    public ResponseResult uploadWork(@ModelAttribute UploadRequest uploadRequest) {
        return uploadService.uploadWork(uploadRequest);
    }

    //---------------------------------作品编辑更新------------------------
    @PutMapping("/update")
    public ResponseResult updateWork(@ModelAttribute UploadRequest uploadRequest) {
        return uploadService.updateWork(uploadRequest);
    }
}
