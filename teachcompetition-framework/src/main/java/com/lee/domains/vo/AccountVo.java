package com.lee.domains.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelProperty;

@Data
public class AccountVo {
    @ExcelProperty("角色")
    private String role;

    @ExcelProperty("学校")
    private String school;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("类别")
    private String category;

    @ExcelProperty("用户名")
    private String username;
}
