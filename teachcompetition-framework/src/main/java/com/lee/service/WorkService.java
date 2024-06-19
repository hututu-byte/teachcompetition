package com.lee.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Work;
import com.lee.domains.vo.WorkReviewVO;
import com.lee.domains.vo.WorkVO;

import java.util.List;

public interface WorkService {
    ResponseResult<Page<WorkVO>> list(String title, String school, String teamMembers, Integer pageNum, Integer pageSize);

    ResponseResult saveOrUpdateWork(Work work);
    ResponseResult getWorkById(Integer workId);

    List<WorkReviewVO> getWorkReviews();
}
