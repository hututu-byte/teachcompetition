package com.lee.domains.vo;

import lombok.Data;

import java.util.Date;

@Data
public class WorkReviewVO {
    private Integer workId;
    private String workName;
    private Date createdAt;
    private Double score;
    private byte reviewStatus; // 0表示未评分，1表示评分
}
