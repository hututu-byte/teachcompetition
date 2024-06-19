package com.lee.domains.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
@Data
@TableName("works")
public class Work {
    @TableId
    private Integer workId;
    private String title;
    private String category;
    private String school;
    private String teamMembers;
    private byte qualification;
    private String contactInfo;
    private Date createdAt;
    private Integer userId;
}

