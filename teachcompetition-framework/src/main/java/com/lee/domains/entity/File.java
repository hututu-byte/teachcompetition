package com.lee.domains.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@TableName("files")
public class File {
    @TableId
    private Integer fileId;
    private Integer workId;
    private String fileType;
    private String fileUrl;
    private String fileName;
    private Date createdAt;
}
