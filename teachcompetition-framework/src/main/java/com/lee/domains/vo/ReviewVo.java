package com.lee.domains.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class ReviewVo {
    @ExcelProperty("学校")
    private String school;

    @ExcelProperty("作品名称")
    private String title;

    @ExcelProperty("评委姓名")
    private String expertName;

    @ExcelProperty("教学实施报告评分")
    private Double teachingReportScore;

    @ExcelProperty("教案评分")
    private Double lessonPlanScore;

    @ExcelProperty("视频资料评分")
    private Double videoMaterialScore;

    @ExcelProperty("专业人才培养方案评分")
    private Double talentTrainingScore;

    @ExcelProperty("课程标准评分")
    private Double courseStandardScore;

    @ExcelProperty("教材选用说明评分")
    private Double textbookUsageScore;

    @ExcelProperty("总评分")
    private Double overallScore;

    @ExcelProperty("提交时间")
    private Date createdAt;
}
