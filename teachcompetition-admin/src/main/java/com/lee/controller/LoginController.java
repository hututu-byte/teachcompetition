package com.lee.controller;



import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Users;
import com.lee.enums.AppHttpCodeEnum;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.lee.service.UsersService;

import javax.annotation.Resource;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2024-06-15 21:43:25
 */
@RestController
@RequestMapping("/admin")
public class LoginController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    //---------------------------------后台管理系统登录------------------------
    @PostMapping("/login")
    public ResponseResult login(@RequestBody Users users){
        return usersService.login(users);
    }

    //---------------------------------后台管理系统退出------------------------
    @PostMapping("/logout")
    public ResponseResult logout(){
        // 清除当前用户的认证信息
        SecurityContextHolder.clearContext();
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS.getCode(), "退出成功");
    }

}

