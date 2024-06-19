package com.lee.domains.dto;

import lombok.Data;

@Data
public class AccountUpdateDto {
    private String role;
    private String school;
    private String name;
    private String username;
    private String password = "123456";
}
