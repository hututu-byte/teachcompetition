package com.lee.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ExportService {
    void exportReviews(HttpServletResponse response) throws IOException;
    void exportAccounts(HttpServletResponse response) throws IOException;
    void exportWorks(HttpServletResponse response) throws IOException;
}
