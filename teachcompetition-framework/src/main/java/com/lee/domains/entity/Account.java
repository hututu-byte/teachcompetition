package com.lee.domains.entity;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelProperty;

@Data
public class Account {
    private String role;

    private String school;

    private String name;

    private String category;

    private String username;
}
