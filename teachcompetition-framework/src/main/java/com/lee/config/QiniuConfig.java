package com.lee.config;

import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class QiniuConfig {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.urlPrefix}")
    private String urlPrefix;

    @Value("${qiniu.region}") // 新增区域配置
    private String region;

    @Bean(name = "qiniuConfiguration")
    public Configuration qiniuConfig() {
        Region selectedRegion;
        switch (region) {
            case "z0":
                selectedRegion = Region.huadong(); // 华东地区
                break;
            case "z1":
                selectedRegion = Region.huabei();  // 华北地区
                break;
            case "z2":
                selectedRegion = Region.huanan();  // 华南地区
                break;
            case "na0":
                selectedRegion = Region.beimei();  // 北美地区
                break;
            case "as0":
                selectedRegion = Region.xinjiapo(); // 新加坡
                break;
            default:
                selectedRegion = Region.autoRegion(); // 自动选择区域
                break;
        }
        return new Configuration(selectedRegion);
    }

    @Bean(name = "qiniuUploadManager")
    public UploadManager uploadManager() {
        return new UploadManager(qiniuConfig());
    }

    @Bean(name = "qiniuAuth")
    public Auth auth() {
        return Auth.create(accessKey, secretKey);
    }

    public String getBucket() {
        return bucket;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }
}
