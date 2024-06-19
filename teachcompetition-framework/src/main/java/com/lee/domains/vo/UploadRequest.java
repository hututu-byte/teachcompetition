package com.lee.domains.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Data
public class UploadRequest {
    private Integer workId; // 新增字段用于更新操作
    private String title;
    private String category;
    private String school;
    private String teamMembers;
    private String contactInfo;
    private Integer userId;
    private Map<String, MultipartFile> files;
    private MultipartFile[] videos;
}
