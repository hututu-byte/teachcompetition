package com.lee.service.impl;

import com.lee.domains.ResponseResult;
import com.lee.domains.entity.File;
import com.lee.domains.entity.Video;
import com.lee.domains.entity.Work;
import com.lee.domains.vo.UploadRequest;
import com.lee.enums.AppHttpCodeEnum;
import com.lee.mapper.WorksMapper;
import com.lee.service.FileService;
import com.lee.service.UploadService;
import com.lee.service.VideoService;
import com.lee.utils.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private WorksMapper workMapper;

    @Autowired
    private FileService fileService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private QiniuUtil qiniuUtil;

    @Override
    public ResponseResult uploadWork(UploadRequest uploadRequest) {
        // 保存作品信息
        Work work = new Work();
        work.setTitle(uploadRequest.getTitle());
        work.setCategory(uploadRequest.getCategory());
        work.setSchool(uploadRequest.getSchool());
        work.setTeamMembers(uploadRequest.getTeamMembers());
        work.setContactInfo(uploadRequest.getContactInfo());
        work.setCreatedAt(new Date());
        workMapper.insert(work);

        // 上传并保存文件
        List<File> savedFiles = new ArrayList<>();
        Map<String, MultipartFile> files = uploadRequest.getFiles();
        for (Map.Entry<String, MultipartFile> entry : files.entrySet()) {
            String fileType = entry.getKey();
            MultipartFile file = entry.getValue();

            // 文件大小校验
            if (file.getSize() > 100 * 1024 * 1024) {
                return ResponseResult.errorResult(AppHttpCodeEnum.FILE_OVER_SIZE, "文件大小不能超过100M");
            }

            // 文件类型校验
            if (!file.getContentType().equals("application/pdf")) {
                return ResponseResult.errorResult(AppHttpCodeEnum.FILE_TYPE_ERROR, "文件类型必须为PDF");
            }

            String fileUrl = qiniuUtil.uploadFile(file);
            if (fileUrl == null) {
                return ResponseResult.errorResult(AppHttpCodeEnum.UPLOAD_NOT_SUCCESSFUL, "文件上传失败");
            }

            File fileEntity = new File();
            fileEntity.setWorkId(work.getWorkId());
            fileEntity.setFileType(fileType);
            fileEntity.setFileUrl(fileUrl);
            fileEntity.setFileName(file.getOriginalFilename());
            fileService.saveFile(fileEntity);
            savedFiles.add(fileEntity);
        }

        // 上传并保存视频
        List<Video> savedVideos = new ArrayList<>();
        MultipartFile[] videos = uploadRequest.getVideos();
        if (videos != null) {
            for (MultipartFile video : videos) {
                // 文件大小校验
                if (video.getSize() > 500 * 1024 * 1024) {
                    return ResponseResult.errorResult(AppHttpCodeEnum.VIDEO_OVER_SIZE, "视频文件大小不能超过500M");
                }

                // 文件类型校验
                if (!video.getContentType().equals("video/mp4")) {
                    return ResponseResult.errorResult(AppHttpCodeEnum.VIDEO_TYPE_ERROR, "视频文件类型必须为MP4");
                }

                String videoUrl = qiniuUtil.uploadFile(video);
                if (videoUrl == null) {
                    return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "视频上传失败");
                }

                Video videoEntity = new Video();
                videoEntity.setWorkId(work.getWorkId());
                videoEntity.setVideoUrl(videoUrl);
                videoEntity.setVideoName(video.getOriginalFilename());
                videoService.saveVideo(videoEntity);
                savedVideos.add(videoEntity);
            }
        }

        return ResponseResult.okResult("作品信息、文件和视频上传成功");
    }

    @Override
    public ResponseResult updateWork(UploadRequest uploadRequest) {
        // 检查作品是否存在
        Work work = workMapper.selectById(uploadRequest.getWorkId());
        if (work == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "作品不存在");
        }

        // 更新作品信息
        work.setTitle(uploadRequest.getTitle());
        work.setCategory(uploadRequest.getCategory());
        work.setSchool(uploadRequest.getSchool());
        work.setTeamMembers(uploadRequest.getTeamMembers());
        work.setContactInfo(uploadRequest.getContactInfo());
        workMapper.updateById(work);

        // 上传并保存文件
        List<File> savedFiles = new ArrayList<>();
        Map<String, MultipartFile> files = uploadRequest.getFiles();
        for (Map.Entry<String, MultipartFile> entry : files.entrySet()) {
            String fileType = entry.getKey();
            MultipartFile file = entry.getValue();

            // 文件大小校验
            if (file.getSize() > 100 * 1024 * 1024) {
                return ResponseResult.errorResult(AppHttpCodeEnum.FILE_OVER_SIZE, "文件大小不能超过100M");
            }

            // 文件类型校验
            if (!file.getContentType().equals("application/pdf")) {
                return ResponseResult.errorResult(AppHttpCodeEnum.FILE_TYPE_ERROR, "文件类型必须为PDF");
            }

            String fileUrl = qiniuUtil.uploadFile(file);
            if (fileUrl == null) {
                return ResponseResult.errorResult(AppHttpCodeEnum.UPLOAD_NOT_SUCCESSFUL, "文件上传失败");
            }

            File fileEntity = new File();
            fileEntity.setWorkId(work.getWorkId());
            fileEntity.setFileType(fileType);
            fileEntity.setFileUrl(fileUrl);
            fileEntity.setFileName(file.getOriginalFilename());
            fileService.saveFile(fileEntity);
            savedFiles.add(fileEntity);
        }

        // 上传并保存视频
        List<Video> savedVideos = new ArrayList<>();
        MultipartFile[] videos = uploadRequest.getVideos();
        if (videos != null) {
            for (MultipartFile video : videos) {
                // 文件大小校验
                if (video.getSize() > 500 * 1024 * 1024) {
                    return ResponseResult.errorResult(AppHttpCodeEnum.VIDEO_OVER_SIZE, "视频文件大小不能超过500M");
                }

                // 文件类型校验
                if (!video.getContentType().equals("video/mp4")) {
                    return ResponseResult.errorResult(AppHttpCodeEnum.VIDEO_TYPE_ERROR, "视频文件类型必须为MP4");
                }

                String videoUrl = qiniuUtil.uploadFile(video);
                if (videoUrl == null) {
                    return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "视频上传失败");
                }

                Video videoEntity = new Video();
                videoEntity.setWorkId(work.getWorkId());
                videoEntity.setVideoUrl(videoUrl);
                videoEntity.setVideoName(video.getOriginalFilename());
                videoService.saveVideo(videoEntity);
                savedVideos.add(videoEntity);
            }
        }

        return ResponseResult.okResult("作品信息、文件和视频修改成功");
    }
}
