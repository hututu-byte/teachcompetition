package com.lee.controller;

import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Users;
import com.lee.enums.AppHttpCodeEnum;
import com.lee.service.UsersService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class LoginController {

    @Resource
    private UsersService usersService;

    //---------------------------------前台页面系统登录------------------------
    @PostMapping("/login")
    public ResponseResult login(@RequestBody Users users){
        return usersService.login(users);
    }

    //---------------------------------前台页面系统退出------------------------
    @PostMapping("/logout")
    public ResponseResult logout(){
        // 清除当前用户的认证信息
        SecurityContextHolder.clearContext();
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS.getCode(), "退出成功");
    }
    //---------------------------------前台页面系统修改密码------------------------
    @PostMapping("/changePassword")
    public ResponseResult changePassword(@RequestParam String username,
                                         @RequestParam String oldPassword,
                                         @RequestParam String newPassword){
        return usersService.changePassword(username, oldPassword, newPassword);
    }
}
