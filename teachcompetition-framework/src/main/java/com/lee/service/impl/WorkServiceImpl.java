package com.lee.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Review;
import com.lee.domains.entity.Work;
import com.lee.domains.vo.WorkReviewVO;
import com.lee.domains.vo.WorkVO;
import com.lee.enums.AppHttpCodeEnum;
import com.lee.mapper.ReviewMapper;
import com.lee.mapper.WorksMapper;
import com.lee.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("workService")
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorksMapper worksMapper;

    @Autowired
    private ReviewMapper reviewMapper;
    @Override
    public ResponseResult<Page<WorkVO>> list(String title, String school, String teamMembers, Integer pageNum, Integer pageSize) {
        Page<WorkVO> page = new Page<>(pageNum, pageSize);
        page.setOptimizeCountSql(false);
        Page<WorkVO> workPage = worksMapper.selectWorks(page, title, school, teamMembers);
        return ResponseResult.okResult(workPage);
    }

    @Override
    public ResponseResult saveOrUpdateWork(Work work) {
        if (work.getWorkId() == null) {
            worksMapper.insert(work);
        } else {
            worksMapper.updateById(work);
        }
        return ResponseResult.okResult(work);
    }

    @Override
    public ResponseResult getWorkById(Integer workId) {
        Work work = worksMapper.selectById(workId);
        if (work == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NOT_WORK,"作品不存在");
        }
        return ResponseResult.okResult(work);
    }

    @Override
    public List<WorkReviewVO> getWorkReviews() {
        List<WorkReviewVO> workReviewList = new ArrayList<>();
        List<Work> works = worksMapper.selectList(null);

        for (Work work : works) {
            WorkReviewVO vo = new WorkReviewVO();
            vo.setWorkId(work.getWorkId());
            vo.setWorkName(work.getTitle());
            vo.setCreatedAt(work.getCreatedAt());

            if (work.getQualification() == 1) {
                QueryWrapper<Review> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("work_id", work.getWorkId())
                        .orderByDesc("created_at").last("LIMIT 1");
                Review review = reviewMapper.selectOne(queryWrapper);

                if (review != null) {
                    vo.setScore(review.getOverallScore());
                    vo.setReviewStatus((byte) 1); // 已评分
                } else {
                    vo.setScore(null);
                    vo.setReviewStatus((byte) 0); // 未评分
                }
            } else {
                vo.setScore(null);
                vo.setReviewStatus((byte) 0); // 未评分
            }

            workReviewList.add(vo);
        }

        return workReviewList;
    }

}
