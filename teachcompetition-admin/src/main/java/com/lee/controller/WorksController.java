package com.lee.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.ResponseResult;
import com.lee.domains.vo.WorkVO;
import com.lee.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/works")
public class WorksController {
    @Autowired
    private WorkService workService;
    //---------------------------------查询所有作品信息列表(分页查询）------------------------
    @GetMapping("/list")
    public ResponseResult<Page<WorkVO>> list(@RequestParam(required = false) String title,
                                             @RequestParam(required = false) String school,
                                             @RequestParam(required = false) String teamMembers,
                                             @RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        return workService.list(title, school, teamMembers, pageNum, pageSize);
    }


}
