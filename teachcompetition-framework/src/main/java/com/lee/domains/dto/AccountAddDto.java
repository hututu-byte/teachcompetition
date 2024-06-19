package com.lee.domains.dto;

import lombok.Data;

@Data
public class AccountAddDto {
    private String role;
    private String school;
    private String name;
    private String category;
    private String username;
    private String password = "123456";
}
