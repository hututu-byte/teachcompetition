package com.lee.service.impl;

import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Users;
import com.lee.enums.AppHttpCodeEnum;
import com.lee.mapper.UsersMapper;
import com.lee.service.UsersService;
import com.lee.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public ResponseResult login(Users users) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword())
            );

            // 获得JWT令牌
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtTokenUtil.generateToken(userDetails);

            Users loggedInUser = usersMapper.findByUsername(users.getUsername());
            loggedInUser.setPassword(null); // Hide password field

            Map<String, Object> data = new HashMap<>();
            data.put("token", token);
            data.put("users", loggedInUser);

            return ResponseResult.okResult(data);
        } catch (Exception e) {
            //登录失败返回报错
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR, "Login failed: " + e.getMessage());
        }
    }


    @Override
    public ResponseResult changePassword(String username, String oldPassword, String newPassword) {
        // 获取用户信息
        Users user = usersMapper.findByUsername(username);
        if (user == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户不存在");
        }

        // 验证旧密码
        if (!oldPassword.equals(user.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PASSWORD_ERROR,"输入与旧密码不一致");
        }

        // 更新密码
        user.setPassword(newPassword);
        usersMapper.updateById(user);
        return ResponseResult.okResult("密码修改成功");
    }
}
