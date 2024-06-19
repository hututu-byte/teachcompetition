package com.lee.domains.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("users")
public class Users  {
    @TableId
    private Integer userId;

    private String username;

    private String password;

    private String role;

    private String name;

    private String avatar;

}

