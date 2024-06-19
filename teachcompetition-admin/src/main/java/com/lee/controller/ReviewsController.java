package com.lee.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.ResponseResult;
import com.lee.domains.vo.ReviewVo;
import com.lee.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/reviews")
public class ReviewsController {

    @Autowired
    private ReviewService reviewService;

    //---------------------------------查询评价信息列表(分页查询）------------------------
    @GetMapping("/list")
    public ResponseResult<Page<ReviewVo>> listReviews(@RequestParam(required = false) String expertName,
                                                      @RequestParam(required = false) String title,
                                                      @RequestParam(required = false) String school,
                                                      @RequestParam(required = false) String teamMembers,
                                                      @RequestParam(required = false) String category,
                                                      @RequestParam(defaultValue = "1") Integer pageNum,
                                                      @RequestParam(defaultValue = "10") Integer pageSize) {
        return reviewService.list(expertName, title, school, teamMembers, category, pageNum, pageSize);
    }

}
