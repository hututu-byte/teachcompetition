package com.lee.domains.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("videos")
public class Video {
    @TableId
    private Integer videoId;
    private Integer workId;
    private String videoUrl;
    private String videoName;
}
