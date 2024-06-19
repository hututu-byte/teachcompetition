package com.lee.service;

import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Users;


/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2024-06-15 21:43:27
 */
public interface UsersService {

    ResponseResult login(Users users);


    ResponseResult changePassword(String username, String oldPassword, String newPassword);
}
