package com.wong.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AliyunSmsConfig {
    public static String accessKeyId;

    public static String secret;

    public static String validateCode;

    public static String orderNotice;

    static {
        //读取配置文件，返回输入流
        InputStream inputStream = QiNiuConfig.class.getClassLoader().getResourceAsStream("aliyun_sms_config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            accessKeyId = properties.getProperty("accessKeyId");
            secret = properties.getProperty("secret");
            validateCode = properties.getProperty("validateCode");
            orderNotice = properties.getProperty("orderNotice");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
