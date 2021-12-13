package com.wong.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class QiNiuConfig {
    public static String accessKey;

    public static String secretKey;

    public static String bucket;

    static {
        //读取配置文件，返回输入流
        InputStream inputStream = QiNiuConfig.class.getClassLoader().getResourceAsStream("qi_niu_config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            accessKey = properties.getProperty("accessKey");
            secretKey = properties.getProperty("secretKey");
            bucket = properties.getProperty("bucket");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
