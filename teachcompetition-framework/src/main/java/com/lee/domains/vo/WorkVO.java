package com.lee.domains.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class WorkVO {
    @ExcelProperty("学校")
    private String school;

    @ExcelProperty("类别")
    private String category;

    @ExcelProperty("作品名称")
    private String title;

    @ExcelProperty("团队成员")
    private String teamMembers;

    @ExcelProperty("联系方式")
    private String contactInfo;

    @ExcelProperty("实时平均分")
    private Double averageScore;
    @ExcelProperty("提交时间")
    private Date createdAt;
}
