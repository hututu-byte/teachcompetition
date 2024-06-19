package com.lee.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.ResponseResult;
import com.lee.domains.dto.AccountAddDto;
import com.lee.domains.dto.AccountUpdateDto;
import com.lee.domains.vo.AccountVo;
import com.lee.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    //---------------------------------查询账号信息列表(分页查询）------------------------
    @GetMapping("/list")
    public ResponseResult<Page<AccountVo>> list(@RequestParam(required = false) String role,
                                                @RequestParam(required = false) String school,
                                                @RequestParam(required = false) String category,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "10") Integer pageSize) {
        return accountService.pageQuery(role, school, category, pageNum, pageSize);
    }
    //---------------------------------添加账号信息--------------------------------------
    @PutMapping("/add")
    public ResponseResult add(@RequestBody AccountAddDto accountAddDto){
        return accountService.add(accountAddDto);
    }
    //---------------------------------修改账号信息--------------------------------------
    @GetMapping("/update/{userId}")
    public ResponseResult update(@PathVariable Integer userId, @RequestBody AccountUpdateDto accountUpdateDto) {
        return accountService.update(userId, accountUpdateDto);
    }
    //---------------------------------删除账号信息--------------------------------------
    @DeleteMapping("/delete/{userId}")
    public ResponseResult delete(@PathVariable Integer userId){
        return accountService.delete(userId);
    }
}
