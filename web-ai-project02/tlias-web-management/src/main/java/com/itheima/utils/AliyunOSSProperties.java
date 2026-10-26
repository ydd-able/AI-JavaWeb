package com.itheima.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")//把配置绑定到属性上。
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String region;
}
