package com.lee.service.impl;

import com.alibaba.excel.EasyExcel;
import com.lee.domains.vo.AccountVo;
import com.lee.domains.vo.ReviewVo;
import com.lee.domains.vo.WorkVO;
import com.lee.mapper.AccountMapper;
import com.lee.mapper.ReviewMapper;
import com.lee.mapper.UsersMapper;
import com.lee.mapper.WorksMapper;
import com.lee.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    private ReviewMapper reviewsMapper;

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private WorksMapper worksMapper;

    @Override
    public void exportReviews(HttpServletResponse response) throws IOException {
        List<ReviewVo> reviews = reviewsMapper.selectAllReviews();

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("评价数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");

        // 使用 EasyExcel 写入数据
        EasyExcel.write(response.getOutputStream(), ReviewVo.class).sheet("Reviews").doWrite(reviews);
    }

    @Override
    public void exportAccounts(HttpServletResponse response) throws IOException {
        // 获取所有账户数据
        List<AccountVo> accounts = accountMapper.selectAllAccounts();

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("账户数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");

        // 使用 EasyExcel 写入数据
        EasyExcel.write(response.getOutputStream(), AccountVo.class).sheet("Accounts").doWrite(accounts);
    }

    @Override
    public void exportWorks(HttpServletResponse response) throws IOException {
        // 获取所有作品数据
        List<WorkVO> works = worksMapper.selectAllWorks();

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("作品数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");

        // 使用 EasyExcel 写入数据
        EasyExcel.write(response.getOutputStream(), WorkVO.class).sheet("Works").doWrite(works);
    }
}
