package com.lee.controller;

import com.lee.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/system/export")
public class ExportController {

    @Autowired
    private ExportService exportService;

    //---------------------------------导出评审excel报表------------------------
    @GetMapping("/reviews")
    public void exportReviews(HttpServletResponse response) throws IOException {
        exportService.exportReviews(response);
        System.out.println("成功导出文件");
    }
    //---------------------------------导出账户excel报表------------------------
    @GetMapping("/accounts")
    public void exportAccounts(HttpServletResponse response) throws IOException {
        exportService.exportAccounts(response);
        System.out.println("成功导出文件");
    }
    //---------------------------------导出作品excel报表------------------------
    @GetMapping("/works")
    public void exportWorks(HttpServletResponse response) throws IOException {
        exportService.exportWorks(response);
        System.out.println("成功导出文件");
    }


}
