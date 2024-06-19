package com.lee.utils;

import com.lee.config.QiniuConfig;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class QiniuUtil {

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private Auth auth;

    @Autowired
    private QiniuConfig qiniuConfig;

    private String getUpToken() {
        return auth.uploadToken(qiniuConfig.getBucket());
    }

    public String uploadFile(MultipartFile file) {
        try {
            Response response = uploadManager.put(file.getBytes(), file.getOriginalFilename(), getUpToken());
            if (response.isOK()) {
                return qiniuConfig.getUrlPrefix() + "/" + file.getOriginalFilename();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
