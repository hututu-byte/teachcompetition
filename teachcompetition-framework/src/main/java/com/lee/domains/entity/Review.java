package com.lee.domains.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("reviews")
public class Review {
    @TableId
    private Integer reviewId;
    private Integer workId;
    private Integer expertId;
    private Double overallScore;
    private Double teachingReportScore;
    private Double lessonPlanScore;
    private Double videoMaterialScore;
    private Double talentTrainingScore;
    private Double courseStandardScore;
    private Double textbookUsageScore;
    private String comments;
    private LocalDateTime createdAt;
}
